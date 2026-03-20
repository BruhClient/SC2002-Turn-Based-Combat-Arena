public interface Action{
  void execute(Combatant player, Combatant target, BattleContext context);
  String getName();
}
