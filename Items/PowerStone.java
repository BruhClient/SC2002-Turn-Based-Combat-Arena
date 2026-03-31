package Items;

import Actions.SpecialSkillAction;
import BattleLogic.BattleContext;
import BattleLogic.Textbox.TextboxPlayerInput;
import Combatants.Combatant;

public class PowerStone extends Item {
	public PowerStone() {
		super("Power Stone", true, false);
	}

	public void useEffect(Combatant user, Combatant useTarget, BattleContext context)
	{
		// Grant special action to user
		SpecialSkillAction specialAction = new SpecialSkillAction();

		Combatant target = TextboxPlayerInput.askCombatant(context.getEnemyCombatants(), true);
		if (target == null){
			System.out.println("No valid target - The Power Stone was wasted...");
			return;
		}
		specialAction.execute(user, target, context);
	};

	@Override
	public Combatant[] getValidTargets(Combatant user, BattleContext context) {
		return context.getPlayerCombatants().toArray(Combatant[]::new);
	}
}