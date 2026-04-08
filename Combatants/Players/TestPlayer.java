package Combatants.Players;

import BattleLogic.Battle.BattleContext;
import Combatants.Combatant;

public class TestPlayer extends Player {
    public TestPlayer() {
        super("Test Player", 300, 30, 15, 35);
    }

    @Override
    public void useSpecialSkill(Combatant target, BattleContext context) {
        // Test player has no special skill
    }

    @Override
    public Combatant[] getSpecialSkillTargets(BattleContext context) {
        return new Combatant[0];
    }
}
