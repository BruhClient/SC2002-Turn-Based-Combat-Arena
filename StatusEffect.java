public interface StatusEffect{
  void onApply(Combatant target);
  void onTurnStart(Combatant target);
  void onTurnEnd(Combatant target);
  boolean isExpired();
  String getName();
}
