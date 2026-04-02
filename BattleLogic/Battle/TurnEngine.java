package BattleLogic.Battle;

import BattleLogic.Textbox.TextboxBattleInfo;
import Combatants.Combatant;
import BattleLogic.SpawnPatterns.LevelSpawns;

import java.util.ArrayList;

public class TurnEngine {
	final private BattleContext battleContext;

	public TurnEngine(LevelSpawns levelSpawns, ArrayList<Combatant> initialCombatants) {
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

		// Update battleContext combatants to also use this order.
		// This way any time combatants are obtained from battleContext, they'll get it in the same speed-based order.
		battleContext.setAllCombatants(turnOrderStrategy.getCombatantOrderList());

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
				combatant.startAction(battleContext); // Run action
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
		battleContext.getCombatants().stream()
				.filter(c -> !c.isAlive())
				.forEach(c -> System.out.println(c.getName() + " ran out of HP and was removed from the battlefield!"));
		battleContext.getCombatants().removeIf(combatant -> !combatant.isAlive());
	}

	public void runNewWaveEffects(){
		battleContext.spawnNextWave();
	}
}
