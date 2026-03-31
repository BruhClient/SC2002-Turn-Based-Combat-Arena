package Actions;
import BattleLogic.BattleContext;
import Combatants.Combatant;

public interface Action{
  void execute(Combatant user, Combatant target, BattleContext context);
  Combatant[] getValidTargets(Combatant user, BattleContext context);
  String getName();
}
