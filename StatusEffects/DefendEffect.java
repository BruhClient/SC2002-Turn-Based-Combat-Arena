package StatusEffects;
import Combatants.Combatant;

public class DefendEffect extends StatusEffect{
  private static final int DEFENSE_BONUS=10;
  public DefendEffect(int duration){
    super(duration);
    statModifier.changeDefense(DEFENSE_BONUS);
  }
  public void onApply(Combatant target){
      System.out.println(target.getName()+"'s defense increased!");
  }
  public void onTurnEnd(Combatant target){
    super.onTurnEnd(target);
    if (isExpired()){
      System.out.println(target.getName()+"'s defense boost expired.");
      }
  }
  public String getName(){
    return "Defend";
  }
}
