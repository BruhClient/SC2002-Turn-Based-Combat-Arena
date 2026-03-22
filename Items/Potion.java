package Items;

import BattleLogic.BattleContext;
import Combatants.Combatant;

public class Potion extends Item {
	final static private int healVal = 100;
	public Potion(String name, boolean consumeOnUse, boolean alwaysTargetSelf) {
		super("Potion", true, true);
	}

	public void useEffect(Combatant user, Combatant useTarget, BattleContext context){
		user.addHp(healVal);
	};
}