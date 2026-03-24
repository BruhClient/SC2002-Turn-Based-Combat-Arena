package Player;

import Combatants.Combatant;
import Items.Item;
import BattleLogic.BattleContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Combatant {
    private List<Item> items = new ArrayList<>();
    private int specialCooldown = 0;

    public Player(String name, int maxHp, int attack, int defense, int speed) {
        super(name, maxHp, attack, defense, speed);
    }

    public abstract void useSpecialSkill(BattleContext context);

    public void useItem(Item item, Combatant target, BattleContext context) {
        item.use(this, target, context);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void RemoveItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public int getSpecialCooldown() {
        return specialCooldown;
    }

    public void setSpecialCooldown(int cooldown) {
        this.specialCooldown = cooldown;
    }
}
