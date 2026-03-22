package Items;

import Actions.SpecialSkillAction;
import BattleLogic.BattleContext;
import Combatants.Combatant;
import StatusEffects.SmokeBombEffect;
import StatusEffects.StatusEffect;

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