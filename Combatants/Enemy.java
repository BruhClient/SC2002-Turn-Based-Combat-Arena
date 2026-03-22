package Combatants;

import Actions.Action;
import Actions.ActionTarget;
import Actions.BasicAttackAction;
import BattleLogic.BattleEngine;
import Items.Item;

import java.util.ArrayList;

public abstract class Enemy extends Combatant {
    public Enemy(String name, int maxHp, int attack, int defense, int speed) {
        super(name, maxHp, attack, defense, speed);
    }
    public ActionTarget decideNextAction(){
        Action action = new BasicAttackAction();
        Combatant target = BattleEngine.getBattleContext().getPlayer();
        return new ActionTarget(action, target);
    }
}
