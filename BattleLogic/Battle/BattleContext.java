package BattleLogic.Battle;

import Combatants.Combatant;
import Combatants.Enemies.Enemy;
import Combatants.Players.Player;
import BattleLogic.SpawnPatterns.LevelSpawns;
import java.util.ArrayList;
import java.util.Random;

/**
 * Stores information about the current battle
 * (Combatants, wave number, and levelSpawns)
 */
public class BattleContext {
	private int waveNum = 0;
	private int turnNum = 0;
	private final LevelSpawns levelSpawns;
	private ArrayList<Combatant> allCombatants;

	public BattleContext(LevelSpawns levelSpawns, ArrayList<Combatant> initialCombatants){
		this.levelSpawns=levelSpawns;
		this.allCombatants = initialCombatants;
	}

	// Getters
	public ArrayList<Combatant> getCombatants(){
		return allCombatants;
	}

	public ArrayList<Player> getPlayerCombatants(){
		// This code does not assume there only being 1 player!
		return getCombatantsOfType(Player.class);
	}

	public Player getRandomPlayerCombatant(){
		// Easy way to deal with multiple players for now
		if (getPlayerCount() == 0){
			return null;
		}
		Random r = new Random();
		return getPlayerCombatants().get(r.nextInt(getPlayerCount()));
	}

	public ArrayList<Enemy> getEnemyCombatants(){
		return getCombatantsOfType(Enemy.class);
	}

	/// Only returns ALIVE combatants
	public <T extends Combatant> ArrayList<T> getCombatantsOfType(Class<T> targetType) {
		ArrayList<T> filteredList = new ArrayList<>();

		if(allCombatants.isEmpty()){
			return filteredList;
		}

		for (Combatant combatant : allCombatants) {
			if (targetType.isInstance(combatant) && combatant.isAlive()) {
				filteredList.add(targetType.cast(combatant));
			}
		}
		return filteredList;
	}

	public int getEnemyCount(){
		return getEnemyCombatants().size();
	}
	public int getPlayerCount(){
		return getPlayerCombatants().size();
	}

	public int getWaveNum(){
		return waveNum;
	}
	public int getMaxWave(){
		return levelSpawns.getMaxWave();
	}
	public int getTurnNum(){
		return turnNum;
	}


	// The only methods that actually change anything
	protected void spawnNextWave(){
		if (waveNum < levelSpawns.getMaxWave()){
			incrementWaveNum();
			levelSpawns.SpawnNextWaveActions(waveNum, this);
		}
	}
	public void addCombatants(ArrayList<Combatant> combatantsToAdd){
		allCombatants.addAll(combatantsToAdd);
	}
	private void incrementWaveNum(){
		waveNum++;
	}
	protected void incrementTurnNum(){
		turnNum++;
	}

	public void setAllCombatants(ArrayList<Combatant> combatants){
		allCombatants = combatants;
	}
}