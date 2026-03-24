package Combatants;

import Actions.Action;
import Actions.ActionTarget;
import Actions.DefendAction;
import BattleLogic.BattleContext;
import Items.Item;
import java.util.ArrayList;

public abstract class Player extends Combatant {
    private ArrayList<Item> items = new ArrayList<>();

    public Player(String name, int maxHp, int attack, int defense, int speed) {
        super(name, maxHp, attack, defense, speed);
    }
    public void RemoveItem(Item item){
        items.remove(item);
    }
    public ActionTarget decideNextAction(BattleContext battleContext){
        // Temporary - Replace with UI asking for action later on
        Action action = new DefendAction();
        Combatant target = battleContext.getPlayer();
        return new ActionTarget(action, target);
    }
}
