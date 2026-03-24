package StatusEffects;
import Combatants.Combatant;

public class DefendEffect extends StatusEffect{
  private static final int DEFENSE_BONUS=10;
  public DefendEffect(int duration){
    super(duration);
  }
  public void onApply(Combatant target){
    target.setDefense(target.getDefense()+DEFENSE_BONUS);
      System.out.println(target.getName()+"'s defense increased!");
  }
  public void onTurnEnd(Combatant target){
    super.onTurnEnd(target);
    if (isExpired()){
      target.setDefense(target.getDefense()-DEFENSE_BONUS);
      System.out.println(target.getName()+"'s defense boost expired.");
      }
  }
  public String getName(){
    return "Defend";
  }
}
