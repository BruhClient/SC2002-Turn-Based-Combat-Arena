public class DefendEffect extends AbstractStatusEffect{
  private static final int DEFENSE_BONUS=10;
  public DefendEffect(int duration){
    super(duration);
  }
  public void onApply(Combatant target){
    target.increaseDefense(DEFENSE_BONUS);
  }
  public void onTurnEnd(Combatant target){
    super.onTurnEnd(target);
    if (isExpired()) {
      target.decreaseDefense(DEFENSE_BONUS);
      System.out.println(target.getName()+"'s defense boost expired.");
      }
  }
  public String getName(){
    return "Defend";
  }
}
