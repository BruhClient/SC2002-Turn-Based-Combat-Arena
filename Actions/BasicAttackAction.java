package Actions;

import BattleLogic.BattleContext;
import Combatants.Combatant;

public class BasicAttackAction implements Action{
  public void execute(Combatant user, Combatant target, BattleContext context){
    int damage=Math.max(0, user.getAttack()-target.getDefense());
    target.takeDamage(damage);
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
