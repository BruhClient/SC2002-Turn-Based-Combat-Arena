import BattleLogic.BattleEngine;
import Combatants.Players.Player;
import Combatants.Players.TestPlayer;
import BattleLogic.SpawnPatterns.LevelSpawns;
import BattleLogic.SpawnPatterns.Spawns_LevelTest;
import Items.Potion;
import Items.SmokeBomb;

class Main {
	public static void main(String[] args)
	{
		// Test scenario
		Player playerCombatant = new TestPlayer();
		playerCombatant.addItem(new Potion());
		playerCombatant.addItem(new Potion());
		playerCombatant.addItem(new SmokeBomb());
		LevelSpawns levelSpawns = new Spawns_LevelTest();

		BattleEngine battleEngine = new BattleEngine();
		battleEngine.startBattle(playerCombatant, levelSpawns);
	}
}