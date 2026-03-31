package Actions;
import BattleLogic.BattleContext;
import Combatants.Combatant;

public class SpecialSkillAction implements Action{
  public void execute(Combatant user, Combatant target, BattleContext context){
    //player.useSpecialSkill(context);
  }

  @Override
  public Combatant[] getValidTargets(Combatant user, BattleContext context) {
    return new Combatant[0]; //TODO
  }

  public String getName(){
    return "Special Skill";
  }
}
