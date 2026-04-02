package Combatants.Players;

import BattleLogic.Battle.BattleContext;

public class TestPlayer extends Player {
    public TestPlayer() {
        super("Test Player", 300, 30, 15, 35);
    }

    @Override
    public void useSpecialSkill(BattleContext context) {
        //
    }
}
