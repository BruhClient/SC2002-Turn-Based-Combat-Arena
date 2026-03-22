package StatusEffects;

public class SmokeBombEffect extends AbstractStatusEffect {
  public SmokeBombEffect(int duration){
    super(duration);
  }
  public String getName(){
    return "Smoke Bomb";
  }
  public boolean negateDamage(){
    return true;
  }
}
