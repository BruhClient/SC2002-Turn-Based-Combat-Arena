package Items;

import BattleLogic.BattleContext;
import Combatants.Combatant;

import static Combatants.Stats.StatList.StatType.HP;

/// Adds 100 hp to the user
public class Potion extends Item {
	final static private int healVal = 100;
	public Potion() {
		super("Potion");
	}

	public void useEffect(Combatant user, Combatant useTarget, BattleContext context){
		System.out.print(user.getName() + " healed " + healVal + " HP! ❤" + user.getStat(HP) + ">");
		user.addHp(healVal);
		System.out.println(user.getStat(HP));

		removeItem();
	}

	@Override
	public Combatant[] getValidTargets(Combatant user, BattleContext context) {
		return context.getPlayerCombatants().toArray(Combatant[]::new);
	}

}