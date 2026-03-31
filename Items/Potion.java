package Items;

import BattleLogic.BattleContext;
import Combatants.Combatant;

public class Potion extends Item {
	final static private int healVal = 100;
	public Potion() {
		super("Potion", true, true);
	}

	public void useEffect(Combatant user, Combatant useTarget, BattleContext context){
		System.out.print(user.getName() + " healed " + healVal + " HP! ❤" + user.getHp() + ">");
		user.addHp(healVal);
		System.out.println(user.getHp());
	}

	@Override
	public Combatant[] getValidTargets(Combatant user, BattleContext context) {
		return context.getPlayerCombatants().toArray(Combatant[]::new);
	}

}