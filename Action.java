public interface Action{
  void execute(Combatant actor, Combatant target, BattleContext context);
  String getName();
}
