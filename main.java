import BattleLogic.BattleEngine;
import Combatants.Player;
import Combatants.TestPlayer;
import SpawnPatterns.LevelSpawns;
import SpawnPatterns.Spawns_LevelTest;

class Main {
	public static void main(String[] args)
	{
		// Test scenario
		Player playerCombatant = new TestPlayer();
		LevelSpawns levelSpawns = new Spawns_LevelTest();
		BattleEngine.startBattle(playerCombatant, levelSpawns);
	}
}