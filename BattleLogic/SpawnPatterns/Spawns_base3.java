package BattleLogic.SpawnPatterns;

import Combatants.Enemies.Goblin;
import Combatants.Enemies.Wolf;

public class Spawns_base3 extends LevelSpawns {

	public Spawns_base3() {
		super("Hard");
	}

	@Override
	void SpawnPattern() {
		super.addSpawn(1, new Goblin("A"));
		super.addSpawn(1, new Goblin("B"));

		super.addSpawn(2, new Goblin("C"));
		super.addSpawn(2, new Wolf("A"));
		super.addSpawn(2, new Wolf("B"));
	}
}
