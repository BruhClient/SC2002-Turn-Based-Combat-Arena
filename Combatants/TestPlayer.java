package Combatants;

import Actions.Action;
import Actions.DefendAction;
import Items.Item;

import java.util.ArrayList;

public class TestPlayer extends Player {
    private ArrayList<Item> items = new ArrayList<>();

    public TestPlayer() {
        super("Test Player", 300, 30, 20, 35);
    }
    public void RemoveItem(Item item){
        items.remove(item);
    }
    public Action decideNextAction(){
        return new DefendAction();
    }
}
