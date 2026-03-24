package BattleLogic;

import Combatants.Combatant;
import Combatants.Player;
import SpawnPatterns.LevelSpawns;

/**
 * Handles running of battles (starting, turn effects, ending)
 */
public class BattleEngine {

	private TurnEngine turnEngine = null;

	public void startBattle(Player playerCombatant, LevelSpawns levelSpawns){
		turnEngine = new TurnEngine(levelSpawns, playerCombatant);
	}

	private void runTurn(){
	}

	private boolean CheckCompleteWave(){
		// If there are no enemies left, wave completed
		return turnEngine.getBattleContext().getEnemyCount() <= 0;
	}

	private boolean CheckCompleteBattle() {
		// If there are no enemies left and reached final wave, battle completed
		return CheckCompleteWave() &&
				(turnEngine.getBattleContext().getWaveNum() < turnEngine.getBattleContext().getWaveCount());
	}

	private void endBattle(){
		System.out.println("end battle");
	}
}