package Combatants.Players;

import BattleLogic.Battle.BattleContext;

public class Wizard extends Player {
    public Wizard() {
        super("Wizard", 200, 50, 10, 20);
    }

    @Override
    public void useSpecialSkill(BattleContext context) {
        arcaneBlast(context);
    }

    public void arcaneBlast(BattleContext context) {
        // TODO: implement arcaneBlast
    }
}
