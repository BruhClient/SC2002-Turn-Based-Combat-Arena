package StatusEffects;

public class StatModifier {
	boolean disableAction = false;
	boolean negateDamage = false;
	int hp = 0;
	int maxHp = 0;
	int attack = 0;
	int defense = 0;
	int speed = 0;

	public StatModifier() {}

	public void disableAction(){this.disableAction = true;}
	public void negateDamage(){this.negateDamage = true;}
	public void changeHp(int num){this.hp = num;}
	public void changeMaxHp(int num){this.maxHp = num;}
	public void changeAttack(int num){this.attack = num;}
	public void changeDefense(int num){this.defense = num;}
	public void changeSpeed(int num){this.speed = num;}

	public boolean getDisableAction(){return disableAction;}
	public boolean getNegateDamage(){return negateDamage;}
	public int getHp(){return hp;}
	public int getMaxHp(){return maxHp;}
	public int getAttack(){return attack;}
	public int getDefense(){return defense;}
	public int getSpeed(){return speed;}
}
