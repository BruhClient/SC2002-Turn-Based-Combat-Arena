package StatusEffects;

public abstract class AbstractStatusEffect implements StatusEffect {
  protected int remainingTurns;
  public AbstractStatusEffect(int duration){
    this.remainingTurns=duration;
  }
  public void onApply(Combatant target){}
  public void onTurnStart(Combatant target){}
  public void onTurnEnd(Combatant target){
    remainingTurns--;
  }
  public boolean isExpired(){
    return remainingTurns<=0;
  }
}
