package BattleLogic.Textbox;

import Actions.Action;
import BattleLogic.BattleContext;
import Combatants.Combatant;
import Items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/// Used for getting player input. (This do be an entirely static class.)
public class TextboxPlayerInput {
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

	///  @see #askGeneral(String, String[], List, boolean)
	public static <T> T askGeneral(String query, String[] descList, ArrayList<T> optionList, boolean allowBacktrack){
		return askGeneral(query, descList, optionList.stream().toList(), allowBacktrack);
	}
	///  @see #askGeneral(String, String[], List, boolean)
	public static <T> T askGeneral(String query, String[] descList,  T[] optionList, boolean allowBacktrack){
		return askGeneral(query, descList, Arrays.stream(optionList).toList(), allowBacktrack);
	}
	/**
	 * Ask for user input to pick between an option in optionList with text displayed in queryList
	 * Special cases: Returns null if no possible options, returns the only option if there is only one.
	 *
	 * @param query String to display when asking user for input
	 * @param descList Lists of string to display for each corresponding optionList
	 * @param optionList Object that is selected (returned) by user
	 * @param allowCancel Gives the user to select 0 to backtrack in the menu. This returns a null.
	 * @return Option picked from optionList
	 * @param <T> Action, Item, Combatant, etc
	 */
	public static <T> T askGeneral(String query, String[] descList, List<T> optionList, boolean allowCancel){
		int length = descList.length;

		if(optionList.isEmpty()) {
			System.out.println("There are no options to pick!");
			return null;
		};
		if(optionList.size() == 1) return optionList.getFirst();

		if(allowCancel){
			System.out.println("0 - Cancel");
		}

		for (int i = 0; i < length; i++) {
			System.out.println(i+1 + " - " + descList[i]);
		}

		int minSelect = allowCancel ? 0 : 1;
		int selectInt = askInt(query, minSelect, length);

		if (selectInt == 0) return null; // Cancel
		return optionList.get(selectInt - 1);
	}

	// More specific askX methods

	/**
	 * Ask for user input to selects a combatant in combatantList. <br>
	 * combatantList will usually be from the battle context's getEnemyCombatants or getPlayerCombatants.
	 * (Note that getting combatants from battlecontext already filters out dead combatants.)
	 * @see #askGeneral(String, String[], List, boolean)
	 * @param combatantList List of combatants.
	 * @see BattleContext#getEnemyCombatants()
	 * @see BattleContext#getPlayerCombatants()
	 * @return Selected combatant
	 */
	public static <T extends Combatant> T askCombatant(List<T> combatantList){
		String[] descList = combatantList.stream()
				.map(Combatant::getName)
				.toArray(String[]::new);
		return askGeneral("Select a target: ", descList, combatantList, true);
	}

	/**
	 * Ask for user input to selects an action in actionList.
	 * @see #askGeneral(String, String[], List, boolean)
	 * @param actionList List of actions.
	 * @return Selected item
	 */
	public static Action askAction(List<Action> actionList){
		String[] descList = actionList.stream()
				.map(Action::getName)
				.toArray(String[]::new);
		return askGeneral("Select an action: ", descList, actionList, true);
	}
	/// @see #askAction(List, String)
	public static Action askAction(List<Action> actionList, String query){
		String[] descList = actionList.stream()
				.map(Action::getName)
				.toArray(String[]::new);
		return askGeneral(query, descList, actionList, true);
	}

	/**
	 * Ask for a user input to select an action in action2dList. <br>
	 * This allows actions to be grouped, bringing up a separate menu for the main list and sub-list.
	 * This action CANNOT be cancelled. It will only return null if there are no valid actions somehow.
	 *
	 * @param action2dList A 2d list of a menu and submenu. Eg: {{basic}, {defend}, {}, {item1, item2}},
	 * @param descList A list for the selection in the top menu ("Basic Attack", "Defend", ...)
	 * @return Action chosen
	 */
	public static Action askAction2D(String[] descList, List<List<Action>> action2dList){

		List<List<Action>> action2dList_filt = new ArrayList<>();
		List<String> descList_filt = new ArrayList<>();

		// If action2dList element is empty, remove it.
		for (int i = 0; i < descList.length; i++) {
			if (!action2dList.get(i).isEmpty()){
				action2dList_filt.add(action2dList.get(i));
				descList_filt.add(descList[i]);
			}
		}

		List<Action> innerMenuList = askGeneral("Select an action: ", descList_filt.toArray(String[]::new), action2dList_filt, false);
		if(innerMenuList == null) return null;
		int optionNumber = action2dList_filt.indexOf(innerMenuList);

		Action selectedAction = askAction(innerMenuList, "Select " + descList[optionNumber] + ": ");
		if (selectedAction == null){
			return askAction2D(descList_filt.toArray(String[]::new), action2dList_filt); // Go up the menu
		}
		return selectedAction;
	}

	/**
	 * Ask for user input to selects an item in itemList.
	 * @see #askGeneral(String, String[], List, boolean)
	 * @param itemList List of items.
	 * @return Selected item
	 */
	public static Item askItem(List<Item> itemList){
		String[] descList = itemList.stream()
				.map(Item::getName)
				.toArray(String[]::new);
		return askGeneral("Select an item: ", descList, itemList, true);
	}
}
