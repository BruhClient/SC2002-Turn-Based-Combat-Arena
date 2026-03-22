package SpawnPatterns;
import Combatants.Combatant;
import java.util.ArrayList;

/**
 * Instance storing all the enemies the level wants to spawn.
 * Wave 2 functions as backup spawn.
 */
public class LevelSpawns {
	private ArrayList<ArrayList<Combatant>> waveList;

	public LevelSpawns(ArrayList<ArrayList<Combatant>> waveList) {
		this.waveList = waveList;
	}

	public LevelSpawns() {}

	public void addSpawn(int waveNum, Combatant combatant){
		while(getWaveCount() < waveNum){
			waveList.add(new ArrayList<Combatant>());
		}
		waveList.get(waveNum-1).add(combatant);
	}

	public int getWaveCount(){
		return waveList.size();
	}
	public ArrayList<Combatant> getWaveSpawn(int waveNum){
		if (waveNum < getWaveCount())
		{
			return null;
		}
		return waveList.get(waveNum-1);
	}
}