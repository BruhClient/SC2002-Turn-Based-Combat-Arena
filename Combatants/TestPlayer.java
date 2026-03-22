package Combatants;

import Actions.Action;
import Actions.ActionTarget;
import Actions.BasicAttackAction;
import Actions.DefendAction;
import BattleLogic.BattleEngine;
import Items.Item;

import java.util.ArrayList;

public class TestPlayer extends Player {
    private ArrayList<Item> items = new ArrayList<>();

    public TestPlayer() {
        super("Test Player", 300, 30, 15, 35);
    }
    public void RemoveItem(Item item){
        items.remove(item);
    }
    public ActionTarget decideNextAction(){
        Action action = new BasicAttackAction();
        Combatant target = BattleEngine.getBattleContext().getEnemyCombatants().getFirst();
        return new ActionTarget(action, target);
    }
}
