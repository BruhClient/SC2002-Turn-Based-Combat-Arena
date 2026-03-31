package BattleLogic.SpawnPatterns;
import BattleLogic.BattleContext;
import Combatants.Combatant;
import java.util.ArrayList;
import java.util.List;

/**
 * Instance storing all the enemies the level wants to spawn.
 * Wave 2 functions as backup spawn.
 */
public class LevelSpawns {
	private ArrayList<ArrayList<Combatant>> waveList = new ArrayList<>();

	public LevelSpawns(ArrayList<ArrayList<Combatant>> waveList) {
		this.waveList = waveList;
	}
	public LevelSpawns() {}

	public void addSpawn(int waveNum, Combatant combatant){
		while(getMaxWave() < waveNum){
			waveList.add(new ArrayList<Combatant>());
		}
		waveList.get(waveNum-1).add(combatant);
	}

	public int getMaxWave(){
		return waveList.size();
	}
	public ArrayList<Combatant> getWaveSpawn(int waveNum){
		if (waveNum > getMaxWave())
		{
			return null;
		}
		return waveList.get(waveNum-1);
	}
	public List<String> getWaveSpawnNames(int waveNum){
		if (waveNum > getMaxWave())
		{
			return null;
		}
		return waveList.get(waveNum-1).stream()
				.map(Combatant::getName)
				.toList();
	}

	public void SpawnNextWaveActions(int waveNum, BattleContext battleContext){
		System.out.println("Started wave " + waveNum);
		battleContext.addCombatants(getWaveSpawn(waveNum));
		// this can be overridden by subclasses to do really funny things on wave spawn
	}
}