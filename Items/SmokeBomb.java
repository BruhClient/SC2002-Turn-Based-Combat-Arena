package Items;

import BattleLogic.BattleContext;
import StatusEffects.SmokeBombEffect;
import Combatants.Combatant;

public class SmokeBomb extends Item {
	public SmokeBomb() {
		super("Smoke Bomb", true, true);
	}
	public void useEffect(Combatant user, Combatant useTarget, BattleContext context)
	{
		// Give useTarget SmokeBombEffect
		SmokeBombEffect newStatus = new SmokeBombEffect(2);
		useTarget.addStatusEffect(newStatus);
	};

	@Override
	public Combatant[] getValidTargets(Combatant user, BattleContext context) {
		return context.getPlayerCombatants().toArray(Combatant[]::new);
	}
}