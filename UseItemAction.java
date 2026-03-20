public class UseItemAction implements Action{
  private Item item;
  public UseItemAction(Item item){
    this.item=item;
  }
  public void execute(Combatant player, Combatant target, BattleContext context){
    item.use(player, context);
  }
  public String getName(){
    return "Use Item";
  }
}
