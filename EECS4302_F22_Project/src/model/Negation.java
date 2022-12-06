package model;

public class Negation extends Condition{
	public Condition cond;
	public int line;
	
	public Negation(Condition cond, int line) {
		this.cond = cond;
		this.line = line;
	}
	
	@Override
	public String toString() {
		return "not " + cond.toString();
	}
}
