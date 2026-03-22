package BattleLogic;

import Combatants.*;
import SpawnPatterns.LevelSpawns;
import java.util.ArrayList;
import Combatants.Combatant;

/**
 * Stores information about the current battle
 * (Combatants, wave number, and levelSpawns)
 */
public class BattleContext {
	private int waveNum = 0;
	private LevelSpawns levelSpawns;
	private ArrayList<Combatant> allCombatants;

	public BattleContext(LevelSpawns levelSpawns, ArrayList<Combatant> initialCombatants){
		this.levelSpawns=levelSpawns;
		this.allCombatants = initialCombatants;
	}
	public BattleContext(LevelSpawns levelSpawns, Combatant initialCombatant){
		this.levelSpawns=levelSpawns;
		this.allCombatants = new ArrayList<>();
		this.allCombatants.add(initialCombatant);
	}
	public void SpawnNextWave(){
		waveNum++;
		allCombatants.addAll(levelSpawns.getWaveSpawn(waveNum));
	}




	public ArrayList<Combatant> getCombatants(){
		return allCombatants;
	}

	public Player getPlayer(){
		return getCombatantsOfType(Player.class).getFirst(); // Assumes only 1 player, but expandable into get random player
	}

	public ArrayList<Enemy> getEnemyCombatants(){
		return getCombatantsOfType(Enemy.class);
	}

	public <T extends Combatant> ArrayList<T> getCombatantsOfType(Class<T> targetType) {
		ArrayList<T> filteredList = new ArrayList<>();

		if(allCombatants.isEmpty()){
			return filteredList;
		}

		for (Combatant combatant : allCombatants) {
			if (targetType.isInstance(combatant)) {
				filteredList.add(targetType.cast(combatant));
			}
		}
		return filteredList;
	}

	public void removeCombatant(Combatant sacrifice){
		allCombatants.remove(sacrifice);
	}



	public int getEnemyCount(){
		return getCombatantsOfType(Enemy.class).size();
	}

	public int getWaveNum(){
		return waveNum;
	}
	public int getWaveCount(){
		return levelSpawns.getWaveCount();
	}


//	public void addStatusEffect(Combatant target, StatusEffect effect){
//		target.addStatusEffect(effect);
//	}
}