package Items;

import BattleLogic.Battle.BattleContext;
import Combatants.Combatant;
import StatusEffects.StunEffect;

import java.util.Random;

/** Additional feature (i wanted to test stuff)
 * Showcases enemy targeting, and non-consumed items. <br>
 * 2/3 chance to do nothing,
 * 1/3 chance to stun an enemy and get consumed
 *
 **/
public class Stunfish extends Item {
	public Stunfish() {
		super("Stunfish");
	}
	public void useEffect(Combatant user, Combatant useTarget, BattleContext context)
	{
		Random random = new Random();
		boolean success = random.nextInt(3) == 1;

		if (success){
			StunEffect newStatus = new StunEffect(3);
			useTarget.addStatusEffect(newStatus);

			System.out.println("The Stunfish exploded!");
			removeItem();
		}
		else {
			System.out.println("The Stunfish failed to work! It can be used again, however.");
		}
	};

	@Override
	public Combatant[] getValidTargets(Combatant user, BattleContext context) {
		return context.getEnemyCombatants().toArray(Combatant[]::new);
	}
}