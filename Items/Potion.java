package Items;

import Combatants.BattleContext;
import Combatants.Combatant;

public class Potion extends AbstractItem {
	final private String name = "Potion";
	final private boolean consumeOnUse = true;

	public void useEffect(Combatant user, Combatant useTarget, BattleContext context){

	};
}