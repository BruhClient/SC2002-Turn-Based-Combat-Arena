package BattleLogic;

import StatusEffects.StatusEffect;
import java.util.List;
import Combatants.Combatant;

public class BattleContext{
    private List<Combatant> allies;
    private List<Combatant> enemies;

    public BattleContext(List<Combatant> allies, List<Combatant> enemies){
      this.allies=allies;
      this.enemies=enemies;
    }

    public List<Combatant> getEnemiesOf(Combatant player){
      if (allies.contains(player)){
        return enemies.stream().filter(Combatant::isAlive).toList();
      } else {
        return allies.stream().filter(Combatant::isAlive).toList();
      }
    }

    public List<Combatant> getAlliesOf(Combatant player){
      if (allies.contains(actor)) {
        return allies.stream().filter(Combatant::isAlive).toList();
      } else {
        return enemies.stream().filter(Combatant::isAlive).toList();
      }
    }

    public void addStatusEffect(Combatant target, StatusEffect effect){
      target.addStatusEffect(effect);
    }

    public void removeCombatant(Combatant combatant){
      allies.remove(combatant);
      enemies.remove(combatant);
    }
}
