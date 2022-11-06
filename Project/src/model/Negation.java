package model;

public class Negation extends Condition{
	Condition cond;
	
	public Negation(Condition cond) {
		this.cond = cond;
	}
	
	@Override
	public String toString() {
		return "not " + cond.toString();
	}
}
