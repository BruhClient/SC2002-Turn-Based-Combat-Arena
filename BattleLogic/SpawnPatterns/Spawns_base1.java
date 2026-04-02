package BattleLogic.SpawnPatterns;

import Combatants.Enemies.*;

public class Spawns_base1 extends LevelSpawns {

	public Spawns_base1() {
		super("Easy");
	}

	@Override
	void SpawnPattern() {
		super.addSpawn(1, new Goblin("A"));
		super.addSpawn(1, new Goblin("B"));
		super.addSpawn(1, new Goblin("C"));
	}
}
