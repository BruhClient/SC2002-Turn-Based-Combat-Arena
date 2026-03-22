package Combatants;

import Actions.Action;
import BattleLogic.BattleContext;
import StatusEffects.StatusEffect;

// Consider fusing with AbstractCombatant? Interface is unnecessary.
public interface Combatant {
    String getName();
    void performAction(Action action, Combatant target, BattleContext battleContext);
    void addStatusEffect(StatusEffect effect);

    public void setHp(int hp);
    public void addHp(int hp);
}
