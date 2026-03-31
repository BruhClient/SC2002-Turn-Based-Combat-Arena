package BattleLogic.Textbox;
import Combatants.Combatant;

import java.util.ArrayList;

public class TextboxBattleInfo {

	public TextboxBattleInfo() {}

	public void printBattleInfo(ArrayList<Combatant> combatants){
		System.out.println("----------------- Current Stats ----------------- ");
		for (Combatant combatant : combatants){
			printCombatantInfo(combatant);
		}
	}

	private void printCombatantInfo(Combatant combatant){

		String name = combatant.getName();
		int hp = combatant.getHp();
		int maxHp = combatant.getMaxHp();
		int speed = combatant.getSpeed();
		int attack = combatant.getAttack();
		int defense = combatant.getDefense();

		String printStr = name;
		printStr = extendStringSpace(printStr, 20); // Makes stats look nicer
		printStr += " ❤"+hp+"/"+maxHp;
		printStr += " ⚡"+speed;
		printStr += " ⚔"+attack;
		printStr += " ⛊"+defense;
		printStr = extendStringSpace(printStr, 43);
		printStr += "[status]";

		//TODO - show status effects (can we give each of them a cool emote icon plsplspls)
		// 🟇⛉♒︎ 🧪🔮💣

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
