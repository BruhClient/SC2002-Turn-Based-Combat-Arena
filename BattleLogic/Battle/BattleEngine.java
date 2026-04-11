package BattleLogic.Battle;

import BattleLogic.Game.GameEngine;
import BattleLogic.Textbox.TextboxBattleInfo;
import BattleLogic.Textbox.TextboxPlayerInput;
import Combatants.Combatant;
import BattleLogic.SpawnPatterns.LevelSpawns;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * Handles running of battles (starting, turn effects, ending)
 */
public class BattleEngine {

	private TurnEngine turnEngine = null;

	// Store these for allowing repeat round
	private Supplier<LevelSpawns> levelSpawnsSupplier;
	private ArrayList<PlayerItemSupplier> playerItemSupplyList;

	public void startBattle(Supplier<LevelSpawns> levelSpawnsSupplier, ArrayList<PlayerItemSupplier> playerItemSupplyList){

		this.levelSpawnsSupplier = levelSpawnsSupplier;
		this.playerItemSupplyList = playerItemSupplyList;

		ArrayList<Combatant> playerCombatants = new ArrayList<>();
		for (PlayerItemSupplier pis : playerItemSupplyList) {
			playerCombatants.add(pis.getCombatant());
		}

		turnEngine = new TurnEngine(levelSpawnsSupplier.get(), playerCombatants);
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

	private void endBattleWin()
	{
		System.out.println("YOU WIN!!!!");
		printEndBattleInfo();
		afterBattleQuery();
	}
	private void endBattleLoss()
	{
		System.out.println("You lost the battle...");
		printEndBattleInfo();
		afterBattleQuery();
	}
	private void printEndBattleInfo(){
		TextboxBattleInfo textboxBattleInfo = new TextboxBattleInfo();
		TurnOrderStrategy turnOrderStrategy = new TurnOrderStrategy(turnEngine.getBattleContext().getCombatants());
		System.out.println("Final Stats | Wave " + turnEngine.getBattleContext().getWaveNum() + " / Turn " + turnEngine.getBattleContext().getTurnNum());
		textboxBattleInfo.printBattleInfo(turnOrderStrategy.getCombatantOrderList());
	}
	private void afterBattleQuery(){
		//TODO - ask for replay same settings, replay, or quit
		System.out.println("Would you like to play again?");

		String[] optionsDesc = {"Replay", "Replay with same settings", "Quit"};
		Integer[] selection = {1, 2, 3};
		int out = TextboxPlayerInput.askGeneral("Select option: ", optionsDesc, selection, false, false);

		switch (out){
			case 1:
				GameEngine.selectGamemode();
				break;
			case 2:
				BattleEngine battleEngine = new BattleEngine();
				battleEngine.startBattle(levelSpawnsSupplier, playerItemSupplyList);
				break;
			default:
		}
	}
}