package Combatants;

import Actions.Action;
import Actions.BasicAttackAction;
import Items.Item;

import java.util.ArrayList;

public class TestEnemy extends Combatant {
    public TestEnemy() {
        super("Test Enemy", 50, 20, 10, 30);
    }
    public Action decideNextAction(){
        return new BasicAttackAction();
    }
}
