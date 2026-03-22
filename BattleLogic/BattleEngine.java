package BattleLogic;

import Combatants.Player;
import Combatants.TestPlayer;
import SpawnPatterns.LevelSpawns;
import SpawnPatterns.Spawns_LevelTest;

/**
 * Handles running of battles (starting, turn effects, ending)
 */
public class BattleEngine {

	final static float actionInterval = 1;

	static int difficultyLevel;
	static BattleContext battleContext = null;

	public static void startBattle(){
		//TO-DO
		Player playerCombatant = new TestPlayer();
		LevelSpawns levelSpawns = new Spawns_LevelTest();
	}

	// I think only the text display really needs this
	public static BattleContext getBattleContext(){
		return battleContext;
	}

	public static void runTurn(){
		// Start turn effects: Apply status effects

		// Mid turn effects: everyone do action

		// End turn effects: things die and stuff
	}

	// TO-DO: Move this to TextboxActions later
	public static void applyDelay(int milliseconds){
		try { Thread.sleep(milliseconds);
		} catch (Exception _) {}
	}
}