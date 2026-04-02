package BattleLogic.Game;

import BattleLogic.Textbox.TextboxPlayerInput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GameEngine {
	private static List<Supplier<GameMode>> modeOptions = new ArrayList<>();
	private static void setupGame() {
		modeOptions = new ArrayList<>(); // Just in case

		// GM_base corresponds to the GameMode for 1 player, 2 items, Spawns_baseX as level spawns.
		// (All the things that the assignment specifications need)
		modeOptions.add(GM_base::new);

		// This allows for extending to include more GameMode
	}

	public static void startGame(){
		GameEngine.setupGame();
		selectGamemode();
	}

	public static void selectGamemode(){
		// Select GameMode
		String[] gamemodeNames = modeOptions.stream()
				.map(Supplier::get)
				.map(GameMode::getName)
				.toArray(String[]::new);
		List<GameMode> gamemodes = modeOptions.stream()
				.map(Supplier::get)
				.toList();
		GameMode selectedGamemode = TextboxPlayerInput.askGeneral("Select Mode: ", gamemodeNames, gamemodes, false, true);
		assert selectedGamemode != null;

		// Starts GameMode
		boolean success = selectedGamemode.selectBattle();
		if (!success) { startGame(); }
	}
}
