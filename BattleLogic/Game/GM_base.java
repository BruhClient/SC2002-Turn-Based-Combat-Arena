package BattleLogic.Game;

import BattleLogic.SpawnPatterns.LevelSpawns;
import BattleLogic.SpawnPatterns.*;
import Combatants.Players.*;
import Items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * The GameMode that the assignment requires
 **/
public class GM_base extends GameMode {

	public GM_base() {
		super("Standard Mode", getPlayerOptions(), getPlayerCount(), getItemOptions(), getItemCount(), getLevelSpawnOptions());
	}

	static private List<Supplier<? extends Player>> getPlayerOptions(){
		List<Supplier<? extends Player>> supplierList = new ArrayList<>();
		supplierList.add(Warrior::new);
		supplierList.add(Wizard::new);

		return supplierList;
	}

	static private int getPlayerCount(){ return 1; }

	static private List<Supplier<? extends Item>> getItemOptions(){
		List<Supplier<? extends Item>> supplierList = new ArrayList<>();
		supplierList.add(Potion::new);
		supplierList.add(PowerStone::new);
		supplierList.add(SmokeBomb::new);

		return supplierList;
	}
	static private int getItemCount(){ return 2; }

	static private List<Supplier<LevelSpawns>> getLevelSpawnOptions(){
		List<Supplier<LevelSpawns>> supplierList = new ArrayList<>();
		supplierList.add(Spawns_base1::new);
		supplierList.add(Spawns_base2::new);
		supplierList.add(Spawns_base3::new);

		return supplierList;
	}
}
