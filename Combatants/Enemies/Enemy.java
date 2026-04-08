package Combatants.Enemies;

import Actions.BasicAttackAction;
import BattleLogic.Battle.BattleContext;
import Combatants.Combatant;
import StatusEffects.StatusEffect;

public abstract class Enemy extends Combatant {
    public Enemy(String name, int maxHp, int attack, int defense, int speed) {
        super(name, maxHp, attack, defense, speed);
    }

    @Override
    public void performAction(BattleContext context) {
        Combatant target = context.getRandomPlayerCombatant();
        if (target != null) {
            BasicAttackAction basicAttack = new BasicAttackAction();
            basicAttack.execute(this, target, context);
        }
    }

    public boolean isStunned() {
        for (StatusEffect status : getStatusEffect()) {
            if (status.statModifier.getDisableAction()) {
                return true;
            }
        }
        return false;
    }
}
