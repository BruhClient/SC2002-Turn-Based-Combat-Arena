package BattleLogic;

import Combatants.Players.Player;
import BattleLogic.SpawnPatterns.LevelSpawns;

/**
 * Handles running of battles (starting, turn effects, ending)
 */
public class BattleEngine {

	private TurnEngine turnEngine = null;

	public void startBattle(Player playerCombatant, LevelSpawns levelSpawns){
		turnEngine = new TurnEngine(levelSpawns, playerCombatant);
		loopTurn();
	}

	private void loopTurn(){

		turnEngine.runNewWaveEffects(); // Start wave 1

		while (true){
			// Run a turn
			turnEngine.runTurn();

			// End battle if meet end game criteria
			if (CheckLostBattle()){
				endBattleLoss();
				return;
			}

			if (CheckCompleteBattle()){
				endBattleWin();
				return;
			}

			// Spawn next wave if wave complete
			if (CheckCompleteWave()){
				turnEngine.runNewWaveEffects();
			}
		}
	}

	private boolean CheckLostBattle(){
		// If there are no players left, battle is lost
		return turnEngine.getBattleContext().getPlayerCount() == 0;
	}

	private boolean CheckCompleteBattle() {
		// If there are no enemies left and reached final wave, battle completed
		return CheckCompleteWave() &&
				(turnEngine.getBattleContext().getWaveNum() >= turnEngine.getBattleContext().getMaxWave());
	}

	private boolean CheckCompleteWave(){
		// If there are no enemies left, wave completed
		return turnEngine.getBattleContext().getEnemyCount() == 0;
	}

	private void endBattleWin(){
		System.out.println("end battle - WIN!");
	}
	private void endBattleLoss(){
		System.out.println("end battle - loss :(");
	}
}