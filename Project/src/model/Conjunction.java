package model;

public class Conjunction extends Condition{
	public Condition cond1;
	public Condition cond2;
	
	public Conjunction(Condition cond1, Condition cond2) {
		this.cond1 = cond1;
		this.cond2 = cond2;
	}
	
	@Override
	public String toString() {
		return cond1.toString() + " && " + cond2.toString();
	}
}
