package Items;

import BattleLogic.Battle.BattleContext;
import BattleLogic.Textbox.TextboxPlayerInput;
import Combatants.Combatant;
import Combatants.Players.Player;

import java.util.Arrays;

/// Triggers the player's special skill without affecting the cooldown timer
public class PowerStone extends Item {
	public PowerStone() {
		super("Power Stone");
	}

	public void useEffect(Combatant user, Combatant useTarget, BattleContext context) {
		if (!(user instanceof Player player)) {
			System.out.println("Only players can use Power Stone!");
			return;
		}

		Combatant[] validTargets = player.getSpecialSkillTargets(context);
		if (validTargets == null || validTargets.length == 0) {
			System.out.println("No valid targets - The Power Stone was not used.");
			return;
		}

		// Select target. (target selection if only one target)
		Combatant target = TextboxPlayerInput.askCombatant(Arrays.stream(validTargets).toList(), false, true);
		if (target == null) {
			System.out.println("The Power Stone was not used.");
			return;
		}

		// Trigger special skill (cooldown is intentionally NOT changed)
		player.useSpecialSkill(target, context);
		removeItem();
	}

	@Override
	public Combatant[] getValidTargets(Combatant user, BattleContext context) {
		return context.getPlayerCombatants().toArray(Combatant[]::new);
	}
}
