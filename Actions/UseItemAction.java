package Actions;
import BattleLogic.BattleContext;
import Items.Item;
import Combatants.Combatant;

public class UseItemAction implements Action {
  private final Item item;
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
