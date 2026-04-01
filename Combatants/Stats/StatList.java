package Combatants.Stats;

import java.util.HashMap;
import java.util.Map;

public class StatList {
	public enum StatType { HP, ATTACK, DEFENSE, SPEED }
	private Map<StatType, Stat> statMap = new HashMap<>();

	public StatList(int hp, int attack, int defense, int speed) {
		this.statMap.put(StatType.HP, new Stat("❤", hp, hp, 0));
		this.statMap.put(StatType.SPEED, new Stat("❯", speed));
		this.statMap.put(StatType.ATTACK, new Stat("⚔", attack));
		this.statMap.put(StatType.DEFENSE, new Stat("⛊", defense));
	}

	public Stat getStat(StatType statType){
		return statMap.get(statType);
	}

	public int getVal(StatType statType){
		return getStat(statType).getStat();
	}
	public int getMaxVal(StatType statType){
		return getStat(statType).getMaxStat();
	}
	public int getMinVal(StatType statType){
		return getStat(statType).getMinStat();
	}
	public String getIcon(StatType statType){
		return getStat(statType).getIcon();
	}
}
