package Actions;
import BattleLogic.BattleContext;
import StatusEffects.DefendEffect;
import Combatants.Combatant;

public class DefendAction implements Action{
  public void execute(Combatant user, Combatant target, BattleContext context){
    user.addStatusEffect(new DefendEffect(2));
    System.out.println(user.getName()+" is defending!");
  }

  @Override
  public Combatant[] getValidTargets(Combatant user, BattleContext context) {
    return new Combatant[]{user};
  }

  public String getName(){
    return "Defend";
  }
}
