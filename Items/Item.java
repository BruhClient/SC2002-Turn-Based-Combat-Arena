package Items;
import Combatants.Combatant;
import Combatants.BattleContext;

public interface Item {
	public void use(Combatant user, Combatant useTarget, BattleContext context);
	public String getName();
}