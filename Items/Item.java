package Items;
import Combatants.Combatant;
import Combatants.BattleContext;

public interface Item {
	public void use(Combatant combatant, BattleContext context);
}