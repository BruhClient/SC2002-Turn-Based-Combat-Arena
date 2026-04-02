package Combatants;
import BattleLogic.Battle.BattleContext;
import Combatants.Stats.StatList;
import StatusEffects.StatusEffect;

import java.util.ArrayList;
import java.util.Iterator;

import static Combatants.Stats.StatList.StatType.*;
import static java.lang.Math.clamp;

public abstract class Combatant {
    private final String name;
    private final StatList stats;
    private final ArrayList<StatusEffect> statusEffects = new ArrayList<>();

    public Combatant(String name, int maxHp, int attack, int defense, int speed) {
        this.name = name;
        this.stats = new StatList(maxHp, attack, defense, speed);
    }

    public String getName() {
        return name;
    }

    public ArrayList<StatusEffect> getStatusEffect(){
        return statusEffects;
    }

    public boolean isAlive() {
        return stats.getVal(HP) > 0;
    }

    public void applyStatusEffectsStart() {
        for (StatusEffect effect : statusEffects) {
            effect.onTurnStart(this);
        }
    }

    public void applyStatusEffectsEnd() {
        Iterator<StatusEffect> it = statusEffects.iterator();

        while (it.hasNext()) {
            StatusEffect effect = it.next();
            effect.onTurnEnd(this);

            if (effect.isExpired()) {
                it.remove();
            }
        }
    }

    public void addStatusEffect(StatusEffect effect) {
        effect.onApply(this);
        statusEffects.add(effect);
    }

    public StatList getStatList(){
        return stats;
    }
    public int getStat(StatList.StatType statType){
        return stats.getEffectiveStat(statType, statusEffects);
    }

    public void setHp(int newHp) { stats.getStat(HP).setStatClamp(newHp); }
    public void addHp(int addHp) { stats.getStat(HP).addStat(addHp); }

    public void startAction(BattleContext battleContext){
        for (StatusEffect status : statusEffects) {
            if (status.statModifier.getDisableAction()){
                // Skip turn!!!
                System.out.println(this.name + " can't move - their action was skipped!");
                return;
            }
        }
        performAction(battleContext);
    }
    public abstract void performAction(BattleContext battleContext);
}
