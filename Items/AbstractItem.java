package Items;

import Combatants.BattleContext;
import Combatants.Combatant;

public abstract class AbstractItem {
	public abstract void use(Combatant combatant, BattleContext context);
}
