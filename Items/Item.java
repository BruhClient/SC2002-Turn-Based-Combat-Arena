package Items;

import Combatants.Player;
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
		if(consumeOnUse) removeItem(user);
	};
	public void use(Combatant user, BattleContext context){
		// get useTarget from message box, unless item doesn't require
		//TO-DO!!!!
		//super(user, useTarget, context);
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

	private void removeItem(Combatant user){
		if (user instanceof Player player){
			player.RemoveItem(this);
		}
	}
}