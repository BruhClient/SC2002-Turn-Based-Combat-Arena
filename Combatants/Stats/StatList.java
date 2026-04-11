package Combatants.Stats;

import StatusEffects.StatusEffect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.clamp;

public class StatList {
	public enum StatType { HP, ATTACK, DEFENSE, SPEED }
	private final Map<StatType, Stat> statMap = new HashMap<>();

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
	public int getEffectiveVal(StatType statType){
		return getStat(statType).getStat();
	}
	public int getMaxVal(StatType statType){
		return getStat(statType).getMaxStat();
	}
	public int getMinVal(StatType statType){
		return getStat(statType).getMinStat();
	}

	public int getEffectiveStat(StatList.StatType statType, List<StatusEffect> statusEffects){
		int num = getVal(statType);
		for (StatusEffect status : statusEffects) {
			num += status.statModifier.getStat(statType).getStat();
		}

		return clamp(num, getEffectiveMinStat(statType, statusEffects), getEffectiveMaxStat(statType, statusEffects));
	}
	public int getEffectiveMaxStat(StatList.StatType statType, List<StatusEffect> statusEffects){
		int num = getMaxVal(statType);
		for (StatusEffect status : statusEffects) {
			num += status.statModifier.getStat(statType).getMaxStat();
		}
		return num;
	}
	public int getEffectiveMinStat(StatList.StatType statType, List<StatusEffect> statusEffects){
		int num = getMinVal(statType);
		for (StatusEffect status : statusEffects) {
			num += status.statModifier.getStat(statType).getMinStat();
		}
		return num;
	}

	public String getIcon(StatType statType){
		return getStat(statType).getIcon();
	}
}
