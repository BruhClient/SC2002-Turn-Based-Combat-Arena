package Actions;
import BattleLogic.BattleContext;
import Combatants.Combatant;
import StatusEffects.DefendEffect;

public class DefendAction implements Action{
  public void execute(Combatant player, Combatant target, BattleContext context){
    player.addStatusEffect(new DefendEffect(2));
    System.out.println(player.getName()+" is defending!");
  }
  public String getName(){
    return "Defend";
  }
}
