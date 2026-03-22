package Actions;

import Combatants.Combatant;

public class ActionTarget
{
	private final Action action;
	private final Combatant target;
	public ActionTarget(Action action, Combatant target) {
		this.action = action;
		this.target = target;
	}

	public Action getAction(){
		return action;
	}
	public Combatant getTarget(){
		return target;
	}
}
