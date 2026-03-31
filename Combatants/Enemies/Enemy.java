package Combatants.Enemies;

import Actions.BasicAttackAction;
import BattleLogic.BattleContext;
import Combatants.Combatant;
import Combatants.Players.Player;

public abstract class Enemy extends Combatant {
    private EnemyStrategy actionStrategy;
    private Player target; // Since enemy can only attack the player

    public Enemy(String name, int maxHp, int attack, int defense, int speed) { // constructor
        super(name, maxHp, attack, defense, speed);
    }

    public void performAction(BattleContext context) { // requires context as argument
        Combatant target = context.getRandomPlayerCombatant();
        BasicAttackAction basicAttack = new BasicAttackAction();
        if (target != null){
            basicAttack.execute(this, context.getRandomPlayerCombatant(), context);
        }
    }

    public boolean isStunned() {
        // ? TO DO
        return false;
    }
}
