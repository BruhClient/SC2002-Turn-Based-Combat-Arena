package BattleLogic.SpawnPatterns;

import Combatants.Enemies.*;

public class Spawns_base2 extends LevelSpawns {

	public Spawns_base2() {
		super("Medium");
	}

	@Override
	void SpawnPattern() {
		super.addSpawn(1, new Goblin());
		super.addSpawn(1, new Wolf("A"));

		super.addSpawn(2, new Wolf("B"));
		super.addSpawn(2, new Wolf("C"));
	}
}
