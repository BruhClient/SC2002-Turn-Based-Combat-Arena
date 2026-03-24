package BattleLogic;

import Combatants.Combatant;
import SpawnPatterns.LevelSpawns;
import java.util.ArrayList;

public class TurnEngine {
	final private BattleContext battleContext;

	public TurnEngine(LevelSpawns levelSpawns, ArrayList<Combatant> initialCombatants) {
		this.battleContext = new BattleContext(levelSpawns, initialCombatants);
	}
	public TurnEngine(LevelSpawns levelSpawns, Combatant initialCombatant) {
		ArrayList<Combatant> initialCombatants = new ArrayList<>();
		initialCombatants.add(initialCombatant);
		this.battleContext = new BattleContext(levelSpawns, initialCombatants);
	}

	public BattleContext getBattleContext() {
		return battleContext;
	}
}
