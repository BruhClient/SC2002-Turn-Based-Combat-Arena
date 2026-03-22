package SpawnPatterns;

import Combatants.TestEnemy;

public class Spawns_LevelTest extends LevelSpawns {
	public Spawns_LevelTest() {
		super.addSpawn(1, new TestEnemy());
		super.addSpawn(1, new TestEnemy());
		super.addSpawn(1, new TestEnemy());
		super.addSpawn(2, new TestEnemy());
		super.addSpawn(2, new TestEnemy());
	}
}
