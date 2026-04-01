package Combatants.Stats;

import java.util.HashMap;
import java.util.Map;

public class StatModifier {
	boolean disableAction = false;
	boolean negateDamage = false;
	private final Map<StatList.StatType, Stat> statChangeMap = new HashMap<>();

	public StatModifier() {
		this.statChangeMap.put(StatList.StatType.HP, new Stat("❤", 0, 0, 0));
		this.statChangeMap.put(StatList.StatType.SPEED, new Stat("❯", 0, 0, 0));
		this.statChangeMap.put(StatList.StatType.ATTACK, new Stat("⚔", 0, 0, 0));
		this.statChangeMap.put(StatList.StatType.DEFENSE, new Stat("⛊", 0, 0, 0));
	}

	public void disableAction(){this.disableAction = true;}
	public void negateDamage(){this.negateDamage = true;}

	public void changeStat(StatList.StatType stat, int amount){
		Stat changedStat = statChangeMap.get(stat);
		changedStat.setStat(amount);
		statChangeMap.replace(stat, changedStat);
	}
	public void changeMaxStat(StatList.StatType stat, int amount){
		Stat changedStat = statChangeMap.get(stat);
		changedStat.setMaxStat(amount);
		statChangeMap.replace(stat, changedStat);
	}
	public void changeMinStat(StatList.StatType stat, int amount){
		Stat changedStat = statChangeMap.get(stat);
		changedStat.setMinStat(amount);
		statChangeMap.replace(stat, changedStat);
	}

	public Stat getStat(StatList.StatType stat){
		return statChangeMap.get(stat);
	}

	public boolean getDisableAction(){return disableAction;}
	public boolean getNegateDamage(){return negateDamage;}
}
