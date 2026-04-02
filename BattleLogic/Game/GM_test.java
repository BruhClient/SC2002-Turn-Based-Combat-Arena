package BattleLogic.Game;

import BattleLogic.SpawnPatterns.*;
import Combatants.Players.Player;
import Combatants.Players.Warrior;
import Combatants.Players.Wizard;
import Items.Item;
import Items.Potion;
import Items.PowerStone;
import Items.SmokeBomb;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * The GameMode that the assignment requires
 **/
public class GM_test extends GameMode {

	public GM_test() {
		super("Test Encounter", getPlayerOptions(), getPlayerCount(), getItemOptions(), getItemCount(), getLevelSpawnOptions());
	}

	static private List<Supplier<? extends Player>> getPlayerOptions(){
		List<Supplier<? extends Player>> supplierList = new ArrayList<>();
		supplierList.add(Warrior::new);
		supplierList.add(Wizard::new);

		return supplierList;
	}

	static private int getPlayerCount(){ return 2; }

	static private List<Supplier<? extends Item>> getItemOptions(){
		List<Supplier<? extends Item>> supplierList = new ArrayList<>();
		supplierList.add(Potion::new);
		supplierList.add(PowerStone::new);
		supplierList.add(SmokeBomb::new);

		return supplierList;
	}
	static private int getItemCount(){ return 3; }

	static private List<Supplier<LevelSpawns>> getLevelSpawnOptions(){
		List<Supplier<LevelSpawns>> supplierList = new ArrayList<>();
		supplierList.add(Spawns_LevelTest::new);

		return supplierList;
	}
}
