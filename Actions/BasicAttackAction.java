package Actions;

import BattleLogic.Battle.BattleContext;
import Combatants.Combatant;
import StatusEffects.StatusEffect;

import static Combatants.Stats.StatList.StatType.*;

public class BasicAttackAction implements Action{
  public void execute(Combatant user, Combatant target, BattleContext context){

    for (StatusEffect status : target.getStatusEffect()) {
      if (status.statModifier.getNegateDamage()){
        System.out.println(user.getName()+" tried to attack "+target.getName() + " but failed!");
        return;
      }
    }

    int damage=target.dealDamage(user);
    System.out.println(user.getName()+" attacks "+target.getName()+" for "+damage+" damage.");
  }

  @Override
  public Combatant[] getValidTargets(Combatant user, BattleContext context) {
    return context.getEnemyCombatants().toArray(Combatant[]::new);
  }

  public String getName(){
      return "Basic Attack";
    }
}
