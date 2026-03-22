package Items;

import BattleLogic.BattleContext;
import Combatants.Combatant;

public class Potion extends Item {
	final private String name = "Potion";
	final private boolean consumeOnUse = true;

	final static private int healVal = 100;

	public void useEffect(Combatant user, Combatant useTarget, BattleContext context){
		user.addHp(healVal);
	};
}