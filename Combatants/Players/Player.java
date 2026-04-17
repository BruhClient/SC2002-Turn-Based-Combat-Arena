package Combatants.Players;

import Actions.*;
import BattleLogic.Textbox.TextboxPlayerInput;
import Combatants.Combatant;
import Items.Item;
import BattleLogic.Battle.BattleContext;
import StatusEffects.StatusEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Player extends Combatant {
    private final List<Item> items = new ArrayList<>();
    private int specialCooldown = 0;

    public Player(String name, int maxHp, int attack, int defense, int speed) {
        super(name, maxHp, attack, defense, speed);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void RemoveItem(Item item) {
        items.remove(item);
    }

    public abstract void useSpecialSkill(Combatant target, BattleContext context);

    public abstract Combatant[] getSpecialSkillTargets(BattleContext context);

    public int getSpecialCooldown() {
        return specialCooldown;
    }

    public void setSpecialCooldown(int cooldown) {
        this.specialCooldown = cooldown;
    }

    @Override
    public void startAction(BattleContext battleContext) {
        if (specialCooldown > 0) { specialCooldown--; }
        super.startAction(battleContext);
    }

    public void performAction(BattleContext battleContext) {
        System.out.println(getName() + "'s turn! Select an action!");
        if (specialCooldown > 0) {
            System.out.println("(Special Skill on cooldown: " + specialCooldown + " turns remaining)");
        }

        // List all possible actions
        List<Action> basicAttackActions = List.of(new BasicAttackAction());
        List<Action> defendActions = List.of(new DefendAction());
        List<Action> specialSkillActions = new ArrayList<>();
        if (specialCooldown == 0) {
            specialSkillActions.add(new SpecialSkillAction());
        }
        List<Action> useItemActions = new ArrayList<>();
        for (Item item : items) {
            useItemActions.add(new UseItemAction(item));
        }

        // Create possible action menu/submenu
        String[] action2dListName = {basicAttackActions.getFirst().getName(), defendActions.getFirst().getName(), "Special Skill", "Item"};
        List<List<Action>> action2dList = List.of(basicAttackActions, defendActions, specialSkillActions, useItemActions);
        Boolean[] action2dListSkipOnSingle = {true, true, true, false};

        // Get the action
        Action actionToApply = TextboxPlayerInput.askAction2D(action2dListName, action2dList, action2dListSkipOnSingle);

        if (actionToApply == null) return;

        // Get target
        Combatant[] validTargets = actionToApply.getValidTargets(this, battleContext);

        if (validTargets == null || validTargets.length == 0) {
            System.out.println("This action has no valid targets!");
            performAction(battleContext);
            return;
        }

        // Skip the target selection only if the only possible target is this
        boolean skipSelection = Arrays.equals(validTargets, new Combatant[]{this});
        Combatant target = TextboxPlayerInput.askCombatant(Arrays.stream(validTargets).toList(), true, skipSelection);
        if (target == null) {
            performAction(battleContext);
            return;
        }

        // Finally, run action
        actionToApply.execute(this, target, battleContext);
    }
}
