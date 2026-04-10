package Combatants.Players;

import BattleLogic.Battle.BattleContext;
import Combatants.Combatant;
import StatusEffects.StunEffect;

import static Combatants.Stats.StatList.StatType.*;

public class Warrior extends Player {
    public Warrior() {
        super("Warrior", 260, 40, 20, 30);
    }

    @Override
    public void useSpecialSkill(Combatant target, BattleContext context) {
        shieldBash(target, context);
    }

    @Override
    public Combatant[] getSpecialSkillTargets(BattleContext context) {
        return context.getEnemyCombatants().toArray(Combatant[]::new);
    }

    public void shieldBash(Combatant target, BattleContext context) {

        if (target.isNegateDamage()){
            System.out.println(getName()+" tried to perform Shield Bash on "+target.getName() + " but failed!");
            return;
        }

        int damage = target.dealDamage(this);
        System.out.println(this.getName() + " performs Shield Bash on " + target.getName() + " for " + damage + " damage!");
        target.addStatusEffect(new StunEffect(2));
    }
}
