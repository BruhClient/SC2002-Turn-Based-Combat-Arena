package StatusEffects;
import Combatants.Combatant;
import Combatants.Stats.StatList;

public class ArcaneBlastEffect extends StatusEffect{

  private int arcaneBlastAmount = 0;
  static int BLAST_DAMAGE_INCRE = 10;

  public ArcaneBlastEffect(){
    super(Integer.MAX_VALUE, "✨︎");
    statModifier.changeStat(StatList.StatType.ATTACK, 10);
  }
  public void onAdd(Combatant target){
    System.out.println(target.getName()+"'s gained a "+BLAST_DAMAGE_INCRE+" damage boost from Arcane Blast!");
  }
  public void onOverride(Combatant target, StatusEffect overriddenStatus){
    // Keep the original status effect, increase its arcaneBlastAmount
    assert(overriddenStatus instanceof ArcaneBlastEffect); // If this isn't true something is wrong...
    ArcaneBlastEffect overriddenArcaneBlast = (ArcaneBlastEffect) overriddenStatus;

    overriddenArcaneBlast.arcaneBlastAmount++;
    int arcaneBoostDmg = BLAST_DAMAGE_INCRE * overriddenArcaneBlast.arcaneBlastAmount;

    overriddenArcaneBlast.statModifier.changeStat(StatList.StatType.ATTACK, arcaneBoostDmg);
    System.out.println(target.getName()+"'s damage boost from Arcane Blast grew to "+arcaneBoostDmg+" damage!");

    // Remove this new one lol
    target.getStatusEffect().remove(this);
  }
  public String getName(){
    return "Arcane Boost";
  }
}
