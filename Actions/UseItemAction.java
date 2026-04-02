package Actions;
import BattleLogic.Battle.BattleContext;
import Items.Item;
import Combatants.Combatant;

public class UseItemAction implements Action {
  private final Item item;
  public UseItemAction(Item item)
  {
    this.item=item;
  }
  public void execute(Combatant user, Combatant target, BattleContext context)
  {
    item.use(user, target, context);
  }
  public String getName()
  {
    return item.getName();
  }

  @Override
  public Combatant[] getValidTargets(Combatant user, BattleContext context) {
    return item.getValidTargets(user, context);
  }
}
