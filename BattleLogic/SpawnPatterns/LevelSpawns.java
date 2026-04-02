package BattleLogic.SpawnPatterns;
import BattleLogic.Battle.BattleContext;
import BattleLogic.Textbox.TextboxBattleInfo;
import Combatants.Combatant;
import java.util.ArrayList;

/**
 * Instance storing all the enemies the level wants to spawn.
 * Wave 2 functions as backup spawn.
 */
public abstract class LevelSpawns {
	private final ArrayList<ArrayList<Combatant>> waveList = new ArrayList<>();
	private String spawnName;
	public LevelSpawns(String spawnName) {
		this.spawnName = spawnName;
		SpawnPattern();
	}
	/// Function that is ran on construction. addSpawn methods should be added here.
	/// (Syntax is nicer like this)
	abstract void SpawnPattern();

	protected void addSpawn(int waveNum, Combatant combatant){
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
	public void printSpawns(){
		for (int i = 1; i <= getMaxWave(); i++) {
			if (getMaxWave() <= 1){
				System.out.println("--- Level Spawns ---");
			} else {
				System.out.println("--- Level Spawns: Wave "+i+ " ---");
			}
			TextboxBattleInfo tb = new TextboxBattleInfo();
			tb.printBattleInfo(getWaveSpawn(i));
		}
	}


//	public List<String> getWaveSpawnNames(int waveNum){
//		if (waveNum > getMaxWave())
//		{
//			return null;
//		}
//		return waveList.get(waveNum-1).stream()
//				.map(Combatant::getName)
//				.toList();
//	}

	public void SpawnNextWaveActions(int waveNum, BattleContext battleContext){
		System.out.println("All enemies have been defeated. Wave " + waveNum + " has started!");
		battleContext.addCombatants(getWaveSpawn(waveNum));
		// this can be overridden by subclasses to do really funny things on wave spawn
	}

	public String getName(){
		return spawnName;
	}
}