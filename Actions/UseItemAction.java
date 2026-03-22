package Actions;
import Items.Item;
import Combatants.Combatant;
import Combatants.BattleContext;

public class UseItemAction implements Action {
  private Item item;
  public UseItemAction(Item item)
  {
    this.item=item;
  }
  public void execute(Combatant player, Combatant target, BattleContext context)
  {
    item.use(player, target, context);
  }
  public String getName()
  {
    return item.getName();
  }
}
