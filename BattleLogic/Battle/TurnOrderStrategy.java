package BattleLogic.Battle;

import Combatants.Combatant;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Combatants.Stats.StatList.StatType.SPEED;

public class TurnOrderStrategy {
	private ArrayList<Combatant> combatantOrderList;

	public TurnOrderStrategy(ArrayList<Combatant> combatants) {
		this.combatantOrderList = arrangeByTurnOrder(combatants);
	}

	private ArrayList<Combatant> arrangeByTurnOrder(ArrayList<Combatant> combatants){
		Stream<Combatant> sortedStream = combatants.stream()
				.sorted((c1, c2) -> c2.getStat(SPEED) - c1.getStat(SPEED));

		ArrayList<Combatant> arrayList = sortedStream.collect(Collectors.toCollection(ArrayList::new));
		return arrayList;
	}

	public ArrayList<Combatant> getCombatantOrderList() {
		return combatantOrderList;
	}
}
