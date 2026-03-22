package SpawnPatterns;

import Combatants.TestEnemy;

public class Spawns_Level1 extends LevelSpawns {
	public Spawns_Level1() {
		super.addSpawn(1, new TestEnemy());
	}
}
