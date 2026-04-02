package BattleLogic.Game;

import BattleLogic.Battle.BattleEngine;
import BattleLogic.Battle.PlayerItemSupplier;
import BattleLogic.SpawnPatterns.LevelSpawns;
import BattleLogic.Textbox.TextboxBattleInfo;
import BattleLogic.Textbox.TextboxPlayerInput;
import Combatants.Combatant;
import Combatants.Players.*;
import Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Instance of selecting a 'GameMode'.
 * A GameMode is a set of Player and Item rules, and set of LevelSpawns to pick from. <br>
 *
 * It allows extending battles to include multiple players and different starting items.
 * (For the project , this is unnecessary)
 **/
public class GameMode {
	private static final boolean CAN_CANCEL = false;

	private final List<Supplier<? extends Player>> playerOptions;
	private int playerCount = 1;
	private final List<Supplier<? extends Item>> itemOptions;
	private int itemCount = 1;
	private final List<Supplier<LevelSpawns>> levelSpawnOptions;

	private String name;

	public GameMode(String name, List<Supplier<? extends Player>> playerOptions,
					int playerCount, List<Supplier<? extends Item>> itemOptions,
					int itemCount, List<Supplier<LevelSpawns>> levelSpawnOptions)
	{
		this.playerOptions = playerOptions;
		this.playerCount = playerCount;
		this.itemOptions = itemOptions;
		this.itemCount = itemCount;
		this.levelSpawnOptions = levelSpawnOptions;
		this.name = name;
	}

	/// Returns false if battle failed to start
	public boolean selectBattle(){
		// Select spawn pattern
		String[] levelSpawnNames = levelSpawnOptions.stream()
				.map(Supplier::get)
				.map(LevelSpawns::getName)
				.toArray(String[]::new);
		Supplier<LevelSpawns> selectedSpawn = TextboxPlayerInput.askGeneral("Select a difficulty: ", levelSpawnNames, levelSpawnOptions, CAN_CANCEL, true);
		if (selectedSpawn == null){ return false; }

		// Show spawn information
		System.out.println("Selected " + selectedSpawn.get().getName() + ". The enemies for this level are:");
		selectedSpawn.get().printSpawns();

		// Select players and items
		ArrayList<PlayerItemSupplier> playerItemSupplyList = new ArrayList<>();

		if (playerOptions.size() > 1){
			String selectPlayerMsg = playerCount == 1 ? "Select a combatant!" : "Select "+playerCount+" combatants!";
			System.out.println(selectPlayerMsg);
		}

		TextboxBattleInfo tb = new TextboxBattleInfo();
		tb.printBattleInfo(playerOptions.stream().<Combatant>map(Supplier::get).toList());

		for (int i = 0; i < playerCount; i++) {
			PlayerItemSupplier selectedPlayerItemSupplier = askPlayerItemSupplier();
			if (selectedPlayerItemSupplier == null){ return selectBattle(); }
			playerItemSupplyList.add(selectedPlayerItemSupplier);
		}

		startBattle(selectedSpawn, playerItemSupplyList); // Start Battle
		return true;
	}

	private PlayerItemSupplier askPlayerItemSupplier(){
		String[] combatantNames = playerOptions.stream()
				.<Player>map(Supplier::get)
				.map(Player::getName)
				.toArray(String[]::new);

		Supplier<? extends Player> selectedCombatantSupplier = TextboxPlayerInput.askGeneral("Select a Player: ",  combatantNames, playerOptions, true, true);
		if (selectedCombatantSupplier == null){ return null; }

		// Ask for item for that player
		if (itemOptions.size() > 1){
			String selectItemMsg = itemCount == 1 ? "Select an item!" : "Select "+itemCount+" items!";
			System.out.println(selectItemMsg);
		}

		ArrayList<Supplier<? extends Item>> itemSupplyList = new ArrayList<>();
		for (int i = 0; i < itemCount; i++) {
			Supplier<? extends Item> selectedItemSupplier = askItemSupplier();
			if (selectedItemSupplier == null){ return askPlayerItemSupplier();}
			itemSupplyList.add(selectedItemSupplier);
		}


		return new PlayerItemSupplier(selectedCombatantSupplier, itemSupplyList);
	}
	private Supplier<? extends Item> askItemSupplier(){
		String[] itemName = itemOptions.stream()
				.<Item>map(Supplier::get)
				.map(Item::getName)
				.toArray(String[]::new);
		return TextboxPlayerInput.askGeneral("Select an item: ", itemName, itemOptions, true, true);
	}

	private void startBattle(Supplier<LevelSpawns> levelSpawnsSupplier, ArrayList<PlayerItemSupplier> playerItemSupplyList){
		BattleEngine battleEngine = new BattleEngine();
		battleEngine.startBattle(levelSpawnsSupplier, playerItemSupplyList);
	}

	public String getName(){
		return name;
	}
}
