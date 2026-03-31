package BattleLogic;

import BattleLogic.Textbox.TextboxBattleInfo;
import Combatants.Combatant;
import BattleLogic.SpawnPatterns.LevelSpawns;
import java.util.ArrayList;

public class TurnEngine {
	final private BattleContext battleContext;

	public TurnEngine(LevelSpawns levelSpawns, ArrayList<Combatant> initialCombatants) {
		this.battleContext = new BattleContext(levelSpawns, initialCombatants);
	}
	public TurnEngine(LevelSpawns levelSpawns, Combatant initialCombatant) {
		ArrayList<Combatant> initialCombatants = new ArrayList<>();
		initialCombatants.add(initialCombatant);
		this.battleContext = new BattleContext(levelSpawns, initialCombatants);
	}

	public BattleContext getBattleContext() {
		return battleContext;
	}

	/// Processes the next turn
	public void runTurn(){
		battleContext.incrementTurnNum();

		// Produce the turn order
		TurnOrderStrategy turnOrderStrategy = new TurnOrderStrategy(getBattleContext().getCombatants());

		// Display stats
		TextboxBattleInfo textboxBattleInfo = new TextboxBattleInfo();
		System.out.println("------------ Wave " + battleContext.getWaveNum() + " / Turn " + battleContext.getTurnNum() + " --------------------");
		textboxBattleInfo.printBattleInfo(turnOrderStrategy.getCombatantOrderList());

		// Run turn effects
		runStartTurnEffects(turnOrderStrategy);
		runCombatantActions(turnOrderStrategy);
		runEndTurnEffects(turnOrderStrategy);
	}

	private void runStartTurnEffects(TurnOrderStrategy turnOrderStrategy){
		for (Combatant combatant : turnOrderStrategy.getCombatantOrderList()) {
			if (combatant.isAlive()){
				// Apply start-turn effects
				combatant.applyStatusEffectsStart();
			}
		}
	}
	private void runCombatantActions(TurnOrderStrategy turnOrderStrategy){
		for (Combatant combatant : turnOrderStrategy.getCombatantOrderList()) {
			if (combatant.isAlive()){
				// Run action
				// combatant.performAction();

				// For temporary testing purposes i will remove -10hp
				System.out.println("test hp loss - " + combatant.getName() + " / HP = " + combatant.getHp() + " -10");
				combatant.addHp(-10);
			}
		}
	}
	private void runEndTurnEffects(TurnOrderStrategy turnOrderStrategy){

		for (Combatant combatant : turnOrderStrategy.getCombatantOrderList()) {
			if (combatant.isAlive()){
				// Apply end turn effects
				combatant.applyStatusEffectsEnd();
			}
		}


		// Remove if dead
		battleContext.getCombatants().removeIf(combatant -> !combatant.isAlive());
	}

	public void runNewWaveEffects(){
		battleContext.spawnNextWave();
	}
}
