package Combatants.Enemies;

public class Goblin extends Enemy {
    public Goblin(String suffix) {
        super("Goblin "+suffix, 55, 35, 15, 25);
    }
    public Goblin() {
        super("Goblin", 55, 35, 15, 25);
    }
}
