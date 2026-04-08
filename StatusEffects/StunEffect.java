package StatusEffects;
import Combatants.Combatant;

public class StunEffect extends StatusEffect{
  public StunEffect(int duration){
    super(duration, "♒︎");
    statModifier.disableAction();
  }
  public void onAdd(Combatant target){
    System.out.println(target.getName()+" is stunned!");
  }
  public String getName(){
    return "Stun";
  }
}
