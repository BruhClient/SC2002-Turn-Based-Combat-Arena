package StatusEffects;
import Combatants.Combatant;
import Combatants.Stats.StatModifier;

public abstract class StatusEffect{
  private String icon;
  protected int remainingTurns;
  public StatusEffect(int duration, String icon){
    this.remainingTurns=duration;
    this.icon = icon;
  }
  public void onApply(Combatant target){}
  public void onTurnStart(Combatant target){}
  public void onTurnEnd(Combatant target){
    if (remainingTurns != Integer.MAX_VALUE){
      remainingTurns--;
    }
  }
  public boolean isExpired(){
    return remainingTurns <= 0;
  }
  public abstract String getName();
  public String getIcon(){return icon;}
  public int getRemainingTurns(){return remainingTurns;}

  public StatModifier statModifier = new StatModifier();
}
