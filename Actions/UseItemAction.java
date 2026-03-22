package Actions;
import Items.Item;
import Combatants.Combatant;

public class UseItemAction implements Action {
  private Item item;
  public UseItemAction(Item item)
  {
    this.item=item;
  }
  public void execute(Combatant player, Combatant target, BattleContext context)
  {
    item.use(player);
  }
  public String getName()
  {
    return "Use Items.Item";
  }
}
