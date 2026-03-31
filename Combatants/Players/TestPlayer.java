package Combatants.Players;

import Actions.*;
import BattleLogic.BattleContext;
import BattleLogic.Textbox.TextboxPlayerInput;
import Combatants.Combatant;
import Items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPlayer extends Player {
    public TestPlayer() {
        super("Test Player", 300, 30, 15, 35);
    }

    @Override
    public void useSpecialSkill(BattleContext context) {
        //
    }
}
