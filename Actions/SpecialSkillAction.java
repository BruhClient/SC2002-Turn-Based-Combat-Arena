package Actions;

import BattleLogic.Battle.BattleContext;
import Combatants.Combatant;
import Combatants.Players.Player;

public class SpecialSkillAction implements Action {
  public void execute(Combatant user, Combatant target, BattleContext context) {
    if (user instanceof Player player) {
      player.useSpecialSkill(target, context);
      player.setSpecialCooldown(3);
    }
  }

  @Override
  public Combatant[] getValidTargets(Combatant user, BattleContext context) {
    if (user instanceof Player player) {
      return player.getSpecialSkillTargets(context);
    }
    return new Combatant[0];
  }

  public String getName() {
    return "Special Skill";
  }
}
