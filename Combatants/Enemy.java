package Combatants;

import Actions.Action;
import Actions.BasicAttackAction;
import Items.Item;

import java.util.ArrayList;

public abstract class Enemy extends Combatant {
    public Enemy(String name, int maxHp, int attack, int defense, int speed) {
        super(name, maxHp, attack, defense, speed);
    }
    public Action decideNextAction(){
        return new BasicAttackAction();
    }
}
