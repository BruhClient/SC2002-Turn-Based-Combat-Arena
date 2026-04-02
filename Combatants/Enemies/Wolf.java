package Combatants.Enemies;

public class Wolf extends Enemy {
    public Wolf(String suffix) {
        super("Wolf "+suffix, 40, 45, 5, 35);
    }
    public Wolf() {
    super("Wolf", 40, 45, 5, 35);
    }
}

