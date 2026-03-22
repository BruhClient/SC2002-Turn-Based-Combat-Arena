package Actions;
import BattleLogic.BattleContext;
import Combatants.Combatant;

public interface Action{
  void execute(Combatant player, Combatant target, BattleContext context);
  String getName();
}
