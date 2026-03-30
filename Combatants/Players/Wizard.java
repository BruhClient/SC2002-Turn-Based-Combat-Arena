package Combatants.Players;

import BattleLogic.BattleContext;

public class Wizard extends Player {
    public Wizard(String name) {
        super(name, 200, 50, 10, 20);
    }

    @Override
    public void useSpecialSkill(BattleContext context) {
        arcaneBlast(context);
    }

    public void arcaneBlast(BattleContext context) {
        // TODO: implement arcaneBlast
    }
}
