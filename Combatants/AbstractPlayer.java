package Combatants;

import Items.Item;
import java.util.ArrayList;

public abstract class AbstractPlayer extends AbstractCombatant {
    private ArrayList<Item> items = new ArrayList<>();

    public AbstractPlayer(String name, int maxHp, int attack, int defense, int speed) {
        super(name, maxHp, attack, defense, speed);
    }
    public void RemoveItem(Item item){
        items.remove(item);
    }
}
