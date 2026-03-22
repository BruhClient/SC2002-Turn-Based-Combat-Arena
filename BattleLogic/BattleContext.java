package BattleLogic;

import SpawnPatterns.LevelSpawns;
import StatusEffects.StatusEffect;
import java.util.List;
import Combatants.Combatant;

/**
 * Stores information about the current battle
 * (Combatants, wave number, and levelSpawns)
 */
public class BattleContext{
	private int waveNum = 0;
	private LevelSpawns levelSpawns;
	private List<Combatant> allCombatants;

	public BattleContext(List<Combatant> combatants){
		this.allCombatants=combatants;
	}
//	public List<Combatant> getEnemiesOf(Combatant player){
//		return allCombatants.stream()
//				.filter(c->c.isEnemy()!=actor.isEnemy() && c.isAlive())
//				.toList();
//	}
//	public List<Combatant> getAlliesOf(Combatant player){
//		return allCombatants.stream()
//		  .filter(c->c.isEnemy()==actor.isEnemy() && c.isAlive())
//		  .toList();
//	}
//	public void addStatusEffect(Combatant target, StatusEffect effect){
//		target.addStatusEffect(effect);
//	}
//	public void removeCombatant(Combatant combatant){
//		allCombatants.remove(combatant);
//	}
}