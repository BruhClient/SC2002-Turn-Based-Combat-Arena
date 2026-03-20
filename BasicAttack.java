public class BasicAttack implements Action {
  public void execute(Combatant player, Combatant target, BattleContext context) {
    int damage=Math.max(0, actor.getAttack()-target.getDefense());
    target.takeDamage(damage);
    System.out.println(actor.getName()+" attacks "+target.getName()+" for "+damage+" damage.");
    }

    public String getName(){
      return "Basic Attack";
    }
}
