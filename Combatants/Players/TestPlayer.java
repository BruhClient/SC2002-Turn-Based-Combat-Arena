package Combatants.Players;

import Actions.Action;
import Actions.ActionTarget;
import Actions.BasicAttackAction;
import BattleLogic.BattleContext;
import Combatants.Combatant;
import Items.Item;

import java.util.ArrayList;

public class TestPlayer extends Player {
    private ArrayList<Item> items = new ArrayList<>();

    public TestPlayer() {
        super("Test Player", 300, 30, 15, 35);
    }

    @Override
    public void useSpecialSkill(BattleContext context) {
        //
    }

    public void RemoveItem(Item item){
        items.remove(item);
    }
    public ActionTarget decideNextAction(BattleContext battleContext){
        Action action = new BasicAttackAction();
        Combatant target = battleContext.getEnemyCombatants().getFirst();
        return new ActionTarget(action, target);
    }
}
