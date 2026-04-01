package BattleLogic;

public class GameEngine {

	public GameEngine() {
		//very much TODO
	}

	private void setupBattle(){

		// Select Level

		// Show details (Enemies, allowed players, allowed items)

		// Select Player

		// Select items

		runBattle(); // Start
	}

	private void runBattle( /* Level, players (w/ their items) */ ){
		BattleEngine battleEngine = new BattleEngine();
		//battleEngine.startBattle(playerCombatant, levelSpawns);

		// ask to retry battle
		// yes, same settings  - rerun this method
		// yes, new game - run setupBattle
		// no - end the program
	}
}
