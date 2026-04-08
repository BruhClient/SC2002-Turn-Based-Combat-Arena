package StatusEffects;
import Combatants.Combatant;
import Combatants.Stats.StatModifier;

import java.util.Objects;

public abstract class StatusEffect{
  private final String icon;
  protected int remainingTurns;
  public StatModifier statModifier = new StatModifier();

  public StatusEffect(int duration, String icon){
    this.remainingTurns=duration;
    this.icon = icon;
  }
  public void onApply(Combatant target){
    // Check if combatant already has the effect. If so, override
    for (StatusEffect statusEffect : target.getStatusEffect()){
      if (statusEffect.getClass().equals(this.getClass()) && statusEffect != this){
        onOverride(target, statusEffect);
        return;
      }
    }
    onAdd(target);
  }

  public boolean isExpired(){
    return remainingTurns <= 0;
  }
  public abstract String getName();
  public String getIcon(){return icon;}
  public int getRemainingTurns(){return remainingTurns;}

  // These methods are to be overridden by the subclasses if necessary
  public void onAdd(Combatant target){}
  public void onOverride(Combatant target, StatusEffect overriddenStatus){
    target.getStatusEffect().remove(overriddenStatus);
    System.out.println(target.getName() + "'s existing " + overriddenStatus.getName() + " was overridden.");
  }
  public void onTurnStart(Combatant target){}
  public void onTurnEnd(Combatant target){
    if (remainingTurns != Integer.MAX_VALUE){
      remainingTurns--;
    }
  }
}
