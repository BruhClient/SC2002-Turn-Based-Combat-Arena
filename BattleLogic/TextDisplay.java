package BattleLogic;

public class TextDisplay {
	Textbox upperTextbox;
	Textbox lowerTextbox;
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