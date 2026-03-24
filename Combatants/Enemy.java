package Combatants;

import Actions.Action;
import Actions.ActionTarget;
import Actions.BasicAttackAction;
import BattleLogic.BattleContext;
import BattleLogic.BattleEngine;
import Items.Item;

import java.util.ArrayList;

public abstract class Enemy extends Combatant {
    public Enemy(String name, int maxHp, int attack, int defense, int speed) {
        super(name, maxHp, attack, defense, speed);
    }
}
