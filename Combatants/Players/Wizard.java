package Combatants.Players;

import BattleLogic.Battle.BattleContext;
import Combatants.Combatant;
import Combatants.Enemies.Enemy;
import StatusEffects.ArcaneBlastEffect;

import java.util.ArrayList;
import java.util.List;

import static Combatants.Stats.StatList.StatType.*;

public class Wizard extends Player {
    public Wizard() {
        super("Wizard", 200, 50, 10, 20);
    }

    @Override
    public void useSpecialSkill(Combatant target, BattleContext context) {
        arcaneBlast(context);
    }

    @Override
    public Combatant[] getSpecialSkillTargets(BattleContext context) {
        // AoE skill - return self so target selection is skipped automatically
        return new Combatant[]{this};
    }

    public void arcaneBlast(BattleContext context) {
        System.out.println(this.getName() + " unleashes Arcane Blast on all enemies!");
        List<Enemy> enemies = new ArrayList<>(context.getEnemyCombatants());
        for (Enemy enemy : enemies) {

            if (enemy.isNegateDamage()){
                System.out.println(this.getName() + " tried to blast " + enemy.getName() + ", but failed!");
                continue;
            }

            int damageDealt = enemy.dealDamage(this);
            System.out.println(this.getName() + " blasts " + enemy.getName() + " for " + damageDealt + " damage!");
            if (!enemy.isAlive()) {
                System.out.println(enemy.getName() + " was eliminated by Arcane Blast! ");
                this.addStatusEffect(new ArcaneBlastEffect());
            }
        }
    }
}
