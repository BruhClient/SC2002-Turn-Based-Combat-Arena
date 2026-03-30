import BattleLogic.BattleEngine;
import Combatants.Players.Player;
import Combatants.Players.TestPlayer;
import BattleLogic.SpawnPatterns.LevelSpawns;
import BattleLogic.SpawnPatterns.Spawns_LevelTest;

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