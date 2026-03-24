import BattleLogic.BattleEngine;
import Combatants.Player;
import Player.TestPlayer;
import SpawnPatterns.LevelSpawns;
import SpawnPatterns.Spawns_LevelTest;

class Main {
	public static void main(String[] args)
	{
		// Test scenario
		Player playerCombatant = new TestPlayer();
		LevelSpawns levelSpawns = new Spawns_LevelTest();

		BattleEngine battleEngine = new BattleEngine();
		battleEngine.startBattle(playerCombatant, levelSpawns);
	}
}