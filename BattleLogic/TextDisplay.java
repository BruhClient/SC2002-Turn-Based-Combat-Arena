package BattleLogic;

public class TextDisplay {
	private Textbox upperTextbox;
	private Textbox lowerTextbox;
	final private static int textInterval = 500;

	private static void applyDelay(int milliseconds){
		try { Thread.sleep(milliseconds);
		} catch (Exception _) {}
	}
	private static void applyDelay() { applyDelay(textInterval); }

	private static void showTextDisplay(){
		//to-dooooo
		//upperTextbox.showText();
		//lowerTextbox.showText();
	}

	public static void updateTextDisplay(){

	}
}

abstract class Textbox {
	protected int textRowCount;

	public Textbox(int textRowCount) {
		this.textRowCount = textRowCount;
	}
	abstract void showText();
}

class TextboxBattleInfo extends Textbox {
	public TextboxBattleInfo(int textRowCount) {
		super(textRowCount);
	}

	@Override
	void showText() {

	}
}