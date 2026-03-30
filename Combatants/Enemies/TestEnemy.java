package Combatants.Enemies;

public class TestEnemy extends Enemy {
    public TestEnemy(String letter) {
        super("Test Enemy " + letter, 50, 20, 10, 30);
    }
    public TestEnemy() {
        super("Test Enemy", 50, 20, 10, 30);
    }
}
