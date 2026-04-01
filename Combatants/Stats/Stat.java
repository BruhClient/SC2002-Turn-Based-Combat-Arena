package Combatants.Stats;

public class Stat {
	String icon;
	int val;
	int maxVal;
	int minVal;

	public Stat(String icon, int val, int maxVal, int minVal) {
		this.icon = icon;
		this.val = val;
		this.maxVal = maxVal;
		this.minVal = minVal;
	}
	public Stat(String icon, int val) {
		this(icon, val, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	public void setStatClamp(int newVal){
		this.val = newVal;
		if (this.val > maxVal) {this.val = maxVal;}
		if (this.val < minVal) {this.val = minVal;}
	}
	/// takes max/min into account when adding
	public void addStat(int addVal){
		setStatClamp(this.val + addVal);
	}
	/// DOES NOT ABIDE BY MIN/MAX
	public void setStat(int newVal){
		this.val = newVal;
	}
	public int getStat(){
		return this.val;
	}

	public void setMaxStat(int newVal){ this.maxVal = newVal; }
	public void addMaxStat(int newVal){ this.maxVal += newVal; }
	public int getMaxStat(){ return this.maxVal; }

	public void setMinStat(int newVal){ this.minVal = newVal; }
	public void addMinStat(int newVal){ this.minVal += newVal; }
	public int getMinStat(){ return this.minVal; }

	public String getIcon() {
		return icon;
	}
}
