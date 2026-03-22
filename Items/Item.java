package Items;

import Combatants.Player;
import Combatants.Combatant;
import BattleLogic.BattleContext;

public abstract class Item {
	private String name;
	private boolean consumeOnUse; // Always true for this project

	/**
	 * Use an item on the useTarget. The item's effects are defined in its class's useEffect.
	 * @param user The combatant using the item
	 * @param useTarget The combatant the item is being used on
	 * @param context Battle Context
	 */
	public void use(Combatant user, Combatant useTarget, BattleContext context){
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

	private void removeItem(Combatant user){
		if (user instanceof Player player){
			player.RemoveItem(this);
		}
	}
}