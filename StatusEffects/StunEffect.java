package StatusEffects;
import Combatants.Combatant;

public class StunEffect extends AbstractStatusEffect {
  public StunEffect(int duration){
    super(duration);
  }
  public void onApply(Combatant target){
    System.out.println(target.getName()+" is stunned!");
  }
  public String getName(){
    return "Stun";
  }
}
