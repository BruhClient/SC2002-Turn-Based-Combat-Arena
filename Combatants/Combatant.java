package Combatants;
import BattleLogic.BattleContext;
import StatusEffects.StatusEffect;

import java.util.ArrayList;
import java.util.Iterator;
import static java.lang.Math.clamp;

public abstract class Combatant {
    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private int speed;
    private ArrayList<StatusEffect> statusEffects = new ArrayList<>();

    public Combatant(String name, int maxHp, int attack, int defense, int speed) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public ArrayList<StatusEffect> getStatusEffect(){
        return statusEffects;
    }

    public boolean isAlive() {
        return hp > 0;
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

    public int getHp() {
        int effectHp = hp;
        for (StatusEffect status : statusEffects) { hp += status.statModifier.getHp();}
        return effectHp;
    }
    public int getMaxHp()   {
        int effectMaxHp = maxHp;
        for (StatusEffect status : statusEffects) { effectMaxHp += status.statModifier.getMaxHp();}
        return effectMaxHp;
    }
    public int getAttack()  {
        int effectAttack = attack;
        for (StatusEffect status : statusEffects) { effectAttack += status.statModifier.getAttack();}
        return effectAttack;
    }
    public int getDefense() {
        int effectDefense = defense;
        for (StatusEffect status : statusEffects) { effectDefense += status.statModifier.getDefense();}
        return effectDefense;
    }
    public int getSpeed() {
        int effectSpeed = speed;
        for (StatusEffect status : statusEffects) { effectSpeed += status.statModifier.getSpeed();}
        return effectSpeed;
    }

    public void setHp(int newHp) {
        this.hp = clamp(newHp, 0, maxHp);
    }
    public void addHp(int addHp) { setHp(hp + addHp); }

    public void startAction(BattleContext battleContext){
        for (StatusEffect status : statusEffects) {
            if (status.statModifier.getDisableAction()){
                // Skip turn!!!
                System.out.println(this.name + "can't move - their action was skipped!");
                return;
            }
        }
        performAction(battleContext);
    }
    public abstract void performAction(BattleContext battleContext);
}
