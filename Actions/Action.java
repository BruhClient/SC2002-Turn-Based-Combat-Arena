package Actions;
import Combatants.BattleContext;
import Combatants.Combatant;

public interface Action{
  void execute(Combatant player, Combatant target, BattleContext context);
  String getName();
}
