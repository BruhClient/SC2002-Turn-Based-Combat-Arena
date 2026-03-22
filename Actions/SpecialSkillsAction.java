package Actions;
import Combatants.Combatant;
import Combatants.BattleContext;

public class SpecialSkillAction implements Action{
  public void execute(Combatant player, Combatant target, BattleContext context){
    player.useSpecialSkill(context);
  }
  public String getName(){
    return "Special Skill";
  }
}
