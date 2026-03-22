package Items;

import Actions.SpecialSkillAction;
import BattleLogic.BattleContext;
import Combatants.Combatant;

public class PowerStone extends Item {
	public PowerStone(String name, boolean consumeOnUse, boolean alwaysTargetSelf) {
		super("Power Stone", true, false);
	}

	public void useEffect(Combatant user, Combatant useTarget, BattleContext context)
	{
		// Grant special action to user
		// useTarget will be the target of the special skill

		// TO-DO: relook after special skill is done
		SpecialSkillAction specialAction = new SpecialSkillAction();
		user.performAction(specialAction, useTarget, context);
	};
}