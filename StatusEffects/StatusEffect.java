package StatusEffects;
import Combatants.Combatant;
import Combatants.Stats.StatModifier;

public abstract class StatusEffect{
  protected int remainingTurns;
  public StatusEffect(int duration){
    this.remainingTurns=duration;
  }
  public void onApply(Combatant target){}
  public void onTurnStart(Combatant target){}
  public void onTurnEnd(Combatant target){
    remainingTurns--;
  }
  public boolean isExpired(){
    return remainingTurns <= 0;
  }
  public abstract String getName();

  public StatModifier statModifier = new StatModifier();
}
