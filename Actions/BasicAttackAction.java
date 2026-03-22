package Actions;

import Combatants.BattleContext;
import Combatants.Combatant;

public class BasicAttackAction implements Action{
  public void execute(Combatant player, Combatant target, BattleContext context){
    int damage=Math.max(0, player.getAttack()-target.getDefense());
    target.takeDamage(damage);
    System.out.println(player.getName()+" attacks "+target.getName()+" for "+damage+" damage.");
    }

    public String getName(){
      return "Basic Attack";
    }
}
