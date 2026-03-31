package Items;

import Combatants.Players.Player;
import Combatants.Combatant;
import BattleLogic.BattleContext;

public abstract class Item {
	private final String name;
	private final boolean consumeOnUse; // Always true for this project
	private final boolean alwaysTargetSelf;

	public Item(String name, boolean consumeOnUse, boolean alwaysTargetSelf) {
		this.name = name;
		this.consumeOnUse = consumeOnUse;
		this.alwaysTargetSelf = alwaysTargetSelf;
	}

	/**
	 * Use an item on the useTarget. The item's effects are defined in its class's useEffect.
	 * @param user The combatant using the item
	 * @param useTarget The combatant the item is being used on
	 * @param context Battle Context
	 */
	public void use(Combatant user, Combatant useTarget, BattleContext context){

		if (user == useTarget){
			System.out.println(user.getName() + " uses a " + this.getName() + "!");
		} else {
			System.out.println(user.getName() + " uses a " + this.getName() + " on " + useTarget.getName() + "!");
		}

		useEffect(user, useTarget, context);
		if(consumeOnUse) removeItem(user);
	};

	/**
	 * @return Name of the item
	 */
	public String getName(){
		return name;
	}

	/**
	 * Method ran when the item is used.
	 * @param user The combatant using the item
	 * @param useTarget The combatant the item is being used on
	 * @param context Battle Context
	 */
	abstract void useEffect(Combatant user, Combatant useTarget, BattleContext context);

	/// Returns an array of combatants that this items should be usable on.
	public abstract Combatant[] getValidTargets(Combatant user, BattleContext context);

	private void removeItem(Combatant user){
		if (user instanceof Player player){
			player.RemoveItem(this);
		}
	}
}