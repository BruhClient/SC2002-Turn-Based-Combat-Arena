package Items;

import Combatants.AbstractPlayer;
import Combatants.BattleContext;
import Combatants.Combatant;

public abstract class AbstractItem implements Item {
	private String name;
	private boolean consumeOnUse;
	public void use(Combatant user, Combatant useTarget, BattleContext context){
		if(consumeOnUse) removeItem(user);
	};

	public abstract void useEffect(Combatant user, Combatant useTarget, BattleContext context);

	public String getName(){
		return name;
	}
	private void removeItem(Combatant user){
		if (user instanceof AbstractPlayer player){
			player.RemoveItem(this);
		}
	}
}