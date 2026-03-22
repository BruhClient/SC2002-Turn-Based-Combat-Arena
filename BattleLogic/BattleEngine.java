package BattleLogic;

import Combatants.Combatant;
import Combatants.Player;
import SpawnPatterns.LevelSpawns;

/**
 * Handles running of battles (starting, turn effects, ending)
 * (Entirely static. Only information stored is battleContext.)
 */
public class BattleEngine {

	public static BattleContext battleContext = null;

	public static void startBattle(Player playerCombatant, LevelSpawns levelSpawns){
		battleContext = new BattleContext(levelSpawns, playerCombatant);

		System.out.println("start context:" + battleContext);
		System.out.println("start context:" + battleContext.getCombatants());
		runTurn();
	}

	// I think only the text display really needs this
	public static BattleContext getBattleContext(){
		return battleContext;
	}


	// to-do: sort enemies in speed order
	// maybe consider checking game end on every action
	// also just make the code less repetitive here
	// Could maybe stream-ify all of this.
	public static void runTurn(){
		// Start turn effects:
		boolean continueGame = CheckCompleteWave(); // Check if start next wave / end battle

		if(!continueGame){
			endBattle();
			return;
		}

		// Run turn start status effects
		runTurnStartStatusEffects();

		// Mid turn effects: everyone do action
		runActionEffects();

		// Run turn end status effects
		runTurnEndStatusEffects();

		// End turn effects: things die and stuff
		runEndTurnEffects();

		runTurn(); // Next turn!
	}

	private static boolean CheckCompleteWave(){
		if (battleContext.getEnemyCount() <= 0){
			// Wave complete
			if (battleContext.getWaveNum() < battleContext.getWaveCount()){
				// Spawn next wave
				System.out.println("SPAWN NEXT WAVEEEEEE" + battleContext.getWaveNum() + " " + battleContext.getWaveCount());
				battleContext.SpawnNextWave();
			}
			else {
				// Stop game
				return false;
			}
		}
		return true;
	}

	private static void runTurnStartStatusEffects(){
		for (Combatant combatant : battleContext.getCombatants()) {
			combatant.applyStatusEffectsStart();
		}
	}
	private static void runTurnEndStatusEffects(){
		for (Combatant combatant : battleContext.getCombatants()) {
			combatant.applyStatusEffectsEnd();
		}
	}
	private static void runActionEffects(){
		for (Combatant combatant : battleContext.getCombatants()) {
			combatant.performAction(battleContext);
		}
	}
	private static void runEndTurnEffects(){
		System.out.println("end turn effects");
		battleContext.getCombatants().removeIf(combatant -> combatant.getHp() == 0);
	}

	private static void endBattle(){
		System.out.println("end battle");
	}
}