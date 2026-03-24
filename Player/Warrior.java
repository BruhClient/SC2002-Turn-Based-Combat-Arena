package Player;

import BattleLogic.BattleContext;

public class Warrior extends Player {
    public Warrior(String name) {
        super(name, 260, 40, 20, 30);
    }

    @Override
    public void useSpecialSkill(BattleContext context) {
        shieldBash(context);
    }

    public void shieldBash(BattleContext context) {
        // TODO: implement shieldBash
    }
}
