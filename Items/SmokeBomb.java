package Items;

import BattleLogic.Battle.BattleContext;
import StatusEffects.SmokeBombEffect;
import Combatants.Combatant;

public class SmokeBomb extends Item {
	public SmokeBomb() {
		super("Smoke Bomb");
	}
	public void useEffect(Combatant user, Combatant useTarget, BattleContext context)
	{
		// Give useTarget SmokeBombEffect
		SmokeBombEffect newStatus = new SmokeBombEffect(2);
		useTarget.addStatusEffect(newStatus);
		System.out.println(useTarget.getName() + " is now immune to attacks!");

		removeItem();
	};

	@Override
	public Combatant[] getValidTargets(Combatant user, BattleContext context) {
		return context.getPlayerCombatants().toArray(Combatant[]::new);
	}
}