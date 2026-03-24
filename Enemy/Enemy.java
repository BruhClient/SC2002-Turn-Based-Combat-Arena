package Enemy;

import BattleLogic.BattleContext;
import Combatants.Combatant;
import Actions.BasicAttackAction;
import Player.Player;


public abstract class Enemy extends Combatant {
    private EnemyStrategy actionStrategy;
    private Player target; // Since enemy can only attack the player
    
    public Enemy(String name, int maxHp, int attack, int defense, int speed) { // constructor
        super(name, maxHp, attack, defense, speed);
    }

    public void performAction(BattleContext context) { // requires context as argument
        BasicAttackAction basicAttack = new BasicAttackAction();
        basicAttack.execute(this, target, context);   // attacker and target are always the same
    }

    public boolean isStunned() {
        // ? TO DO
        return false;
    }
}
