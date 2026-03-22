package Items;

import BattleLogic.BattleContext;
import StatusEffects.SmokeBombEffect;
import Combatants.Combatant;

public class SmokeBomb extends Item {
	final private String name = "Smoke Bomb";
	final private boolean consumeOnUse = true;

	public void useEffect(Combatant user, Combatant useTarget, BattleContext context)
	{
		// Give useTarget SmokeBombEffect
		SmokeBombEffect newStatus = new SmokeBombEffect(2);
		useTarget.addStatusEffect(newStatus);
	};
}