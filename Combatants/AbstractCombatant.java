package Combatants;
import Actions.Action;
import BattleLogic.BattleContext;
import BattleLogic.BattleEngine;
import StatusEffects.StatusEffect;
import java.util.ArrayList;
import java.util.Iterator;
import static java.lang.Math.clamp;

public abstract class AbstractCombatant implements Combatant {
    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private int speed;
    private ArrayList<StatusEffect> statusEffects = new ArrayList<>();

    public AbstractCombatant(String name, int maxHp, int attack, int defense, int speed) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    @Override
    public String getName() {
        return name;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
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

    public int getHp()      { return hp; }
    public int getMaxHp()   { return maxHp; }
    public int getAttack()  { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed()   { return speed; }

    public void setHp(int newHp) { this.hp = clamp(newHp, 0, maxHp); }
    public void addHp(int addHp) { setHp(hp + addHp); }
    public void setDefense(int defense) { this.defense = defense; }

    public void performAction(Action action, Combatant target, BattleContext battleContext){
        action.execute(this, target, battleContext);
    };
}
