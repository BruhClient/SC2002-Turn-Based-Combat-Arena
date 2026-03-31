package BattleLogic.Textbox;

import BattleLogic.BattleEngine;
import BattleLogic.SpawnPatterns.LevelSpawns;
import BattleLogic.SpawnPatterns.Spawns_LevelTest;
import Combatants.Combatant;
import Combatants.Enemies.TestEnemy;
import Combatants.Enemies.TestEnemy2;
import Combatants.Players.Player;
import Combatants.Players.TestPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TextboxPlayerInput {
	public static void main(String[] args)
	{
		// test method
		System.out.println("test.");
		String[] descList = {"q1", "q2", "q3"};
		Combatant[] returnList = {new TestPlayer(), new TestEnemy(), new TestEnemy2()};
		Combatant returnComb = askGeneral("askQn. insert int: ", descList, returnList);
		System.out.println(returnComb.getName());
	}

	/**
	 * Ask for user input to pick between an option in optionList with text displayed in queryList
	 * @param query String to display when asking user for input
	 * @param descList Lists of string to display for each corresponding optionList
	 * @param optionList Object that is selected (returned) by user
	 * @return Option picked from optionList
	 * @param <T> Action, Item, Combatant, etc
	 */
	public static <T> T askGeneral(String query, String[] descList, ArrayList<T> optionList){
		return askGeneral(query, descList, optionList.stream().toList());
	}
	public static <T> T askGeneral(String query, String[] descList,  T[] optionList){
		return askGeneral(query, descList, Arrays.stream(optionList).toList());
	}
	public static <T> T askGeneral(String query, String[] descList, List<T> optionList){
		// things.
		int length = descList.length;
		for (int i = 0; i < length; i++) {
			System.out.println(i+1 + " - " + descList[i]);
		}
		int selectInt = askInt(query, 1, length);
		return optionList.get(selectInt - 1);
	}

	private static int askInt(String query){
		return askInt(query, 0, Integer.MAX_VALUE);
	}
	private static int askInt(String query, int max){
		return askInt(query, 0, max);
	}
	private static int askInt(String query, int min, int max){
		Scanner sc = new Scanner(System.in);
		System.out.print(query);
		try {
			int selectedInt = sc.nextInt();
			if (selectedInt < min || selectedInt > max){
				throw new Exception("Too small / large");
			}
			return selectedInt;

		} catch (Exception e) {
			System.out.println("Invalid value. Select another.");
			return askInt(query, min, max);
		}
	}
}
