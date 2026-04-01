package Combatants.Players;

import BattleLogic.BattleContext;

public class Warrior extends Player {
    public Warrior() {
        super("Warrior", 260, 40, 20, 30);
    }

    @Override
    public void useSpecialSkill(BattleContext context) {
        shieldBash(context);
    }

    public void shieldBash(BattleContext context) {
        // TODO: implement shieldBash
    }
}
