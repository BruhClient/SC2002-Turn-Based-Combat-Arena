package BattleLogic.Battle;

import Combatants.Players.Player;
import Items.Item;

import java.util.ArrayList;
import java.util.function.Supplier;

/// issue with new is you can't reuse it. so... go my suppliers
public class PlayerItemSupplier {
	Supplier<? extends Player> combatantSupplier;
	ArrayList<Supplier<? extends Item>> itemSupplierList;

	public PlayerItemSupplier(Supplier<? extends Player> combatantSupplier, ArrayList<Supplier<? extends Item>> itemSupplierList) {
		this.combatantSupplier = combatantSupplier;
		this.itemSupplierList = itemSupplierList;
	}

	public Player getCombatant(){
		Player combatant = combatantSupplier.get();

		for (Supplier<? extends Item> itemSupply : itemSupplierList) {
			combatant.addItem(itemSupply.get());
		}
		return combatant;
	}
}
