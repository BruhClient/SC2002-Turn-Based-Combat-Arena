package Items;

import BattleLogic.BattleContext;
import Combatants.Combatant;
import StatusEffects.StunEffect;

import java.util.Random;

/** Additional feature (i wanted to test stuff)
 * Showcases enemy targeting, and non-consumed items. <br>
 * 1/2 chance to do nothing,
 * 1/2 chance to stun an enemy,
 * 1/2 chance to stun an enemy AND get consumed
 *
 **/
public class Stunfish extends Item {
	public Stunfish() {
		super("Stunfish");
	}
	public void useEffect(Combatant user, Combatant useTarget, BattleContext context)
	{
		Random random = new Random();
		boolean success = random.nextInt(2) == 1;

		if (success){
			StunEffect newStatus = new StunEffect(2);
			useTarget.addStatusEffect(newStatus);
			System.out.println(useTarget.getName() + " has been stunned!");

			boolean explode = random.nextInt(2) == 1;
			if (explode){
				System.out.println("The Stunfish exploded!");
			} else {
				System.out.println("The Stunfish did not explode. You can use it again!");
			}
		}
		else {
			System.out.println("The fish failed to work! It can be used again, however.");
		}
	};

	@Override
	public Combatant[] getValidTargets(Combatant user, BattleContext context) {
		return context.getEnemyCombatants().toArray(Combatant[]::new);
	}
}