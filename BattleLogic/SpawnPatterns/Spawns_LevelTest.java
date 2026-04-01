package BattleLogic.SpawnPatterns;

import Combatants.Enemies.*;

public class Spawns_LevelTest extends LevelSpawns {
	@Override
	void SpawnPattern() {
		super.addSpawn(1, new TestEnemy("1A"));
		super.addSpawn(1, new TestEnemy("1B"));
		super.addSpawn(1, new TestEnemy2());
		super.addSpawn(1, new TestEnemy("1C"));
		super.addSpawn(1, new TestEnemy("1D"));

		super.addSpawn(2, new TestEnemy2("2A"));
		super.addSpawn(2, new TestEnemy2("2B"));
		super.addSpawn(2, new TestEnemy());
	}
}
