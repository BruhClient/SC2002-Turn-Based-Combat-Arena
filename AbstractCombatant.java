public abstract class AbstractCombatant implements Combatant {
    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private int speed;

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

    public int getHp()      { return hp; }
    public int getMaxHp()   { return maxHp; }
    public int getAttack()  { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed()   { return speed; }

    protected void setHp(int hp) { this.hp = hp; }
    protected void setDefense(int defense) { this.defense = defense; }
}
