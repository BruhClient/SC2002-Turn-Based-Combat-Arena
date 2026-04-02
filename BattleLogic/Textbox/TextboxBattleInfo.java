package BattleLogic.Textbox;
import Combatants.Combatant;
import Combatants.Stats.Stat;
import Combatants.Stats.StatList;
import StatusEffects.StatusEffect;

import static Combatants.Stats.StatList.StatType;

import java.util.List;

public class TextboxBattleInfo {

	public TextboxBattleInfo() {}

	public void printBattleInfo(List<Combatant> combatants){
		for (Combatant combatant : combatants){
			printCombatantInfo(combatant);
		}
	}

	private void printCombatantInfo(Combatant combatant){

		String name = combatant.getName();
		StatList statList = combatant.getStatList();
		List<StatusEffect> statusEffects = combatant.getStatusEffect();

		String printStr = name;
		printStr = extendStringSpace(printStr, 20); // Makes stats look nicer

		for (StatType statType : StatType.values()){
			Stat stats = statList.getStat(statType);
			String icon = stats.getIcon();
			int val = statList.getEffectiveStat(statType, statusEffects);
			printStr += " "+icon+val;

			int maxVal = stats.getMaxStat();
			if (maxVal < Integer.MAX_VALUE){
				printStr += "/"+maxVal;
			}
		}

		printStr = extendStringSpace(printStr, 43);

		// Status icons!
		for (StatusEffect statusEffect : combatant.getStatusEffect()){
			printStr += " " + statusEffect.getIcon();
			if (statusEffect.getRemainingTurns() < Integer.MAX_VALUE){
				printStr += statusEffect.getRemainingTurns();
			} else { printStr += "Ꝏ"; }
		}

		// 🟇

		System.out.println(printStr);
	}

	/// Extend the length of string to a set length with spaces
	private String extendStringSpace(String string, int amount){
		StringBuilder stringBuilder = new StringBuilder(string);
		while (stringBuilder.length() < amount){
			stringBuilder.append(" ");
		}
		string = stringBuilder.toString();
		return string;
	}
}
