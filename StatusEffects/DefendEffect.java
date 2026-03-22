package StatusEffects;
import Combatants.Combatant;

public class DefendEffect extends StatusEffect{
  private static final int DEFENSE_BONUS=10;
  public DefendEffect(int duration){
    super(duration);
  }
  public void onApply(Combatant target){
    target.addStatusEffect(new DefendEffect(2));
  }
  public void onTurnEnd(Combatant target){
    super.onTurnEnd(target);
  }
  public String getName(){
    return "Defend";
  }
}
