package Combatants.Players;

import Actions.*;
import BattleLogic.Textbox.TextboxPlayerInput;
import Combatants.Combatant;
import Items.Item;
import BattleLogic.BattleContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Player extends Combatant {
    private List<Item> items = new ArrayList<>();
    private int specialCooldown = 0;

    public Player(String name, int maxHp, int attack, int defense, int speed) {
        super(name, maxHp, attack, defense, speed);
    }

    public abstract void useSpecialSkill(BattleContext context);

    public void useItem(Item item, Combatant target, BattleContext context) {
        item.use(this, target, context);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void RemoveItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public int getSpecialCooldown() {
        return specialCooldown;
    }

    public void setSpecialCooldown(int cooldown) {
        this.specialCooldown = cooldown;
    }

    public void performAction(BattleContext battleContext){

        // List all possible actions
        List<Action> basicAttackActions = List.of(new BasicAttackAction());
        List<Action> defendActions = List.of(new DefendAction());
        List<Action> specialSkillActions = List.of(new SpecialSkillAction());
        List<Action> useItemActions = new ArrayList<>();

        for (Item item : items) {
            useItemActions.add(new UseItemAction(item));
        }

        // Create possible action menu/submenu
        String[] action2dListName = {basicAttackActions.getFirst().getName(), defendActions.getFirst().getName(), specialSkillActions.getFirst().getName(), "Item"};
        List<List<Action>> action2dList = List.of(basicAttackActions, defendActions, specialSkillActions, useItemActions);

        // Get the action
        Action actionToApply = TextboxPlayerInput.askAction2D(action2dListName, action2dList);

        if(actionToApply == null) return; // This should only appear if there's no valid actions to do. Somehow.

        // Get target
        Combatant[] validTargets = actionToApply.getValidTargets(this, battleContext);

        if(validTargets == null || validTargets.length == 0){
            System.out.println("This action has no valid targets!");
            performAction(battleContext); return; // Rerun
        }

        Combatant target = TextboxPlayerInput.askCombatant(Arrays.stream(validTargets).toList());
        if(target == null){
            performAction(battleContext); return; // Rerun (cancelled option)
        }

        // Finally, run action
        actionToApply.execute(this, target, battleContext);
    }
}
