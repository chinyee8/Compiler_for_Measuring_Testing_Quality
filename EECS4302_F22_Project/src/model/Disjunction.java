package model;

public class Disjunction extends Condition{
	public Condition cond1;
	public Condition cond2;
	public int line;
	
	public Disjunction(Condition cond1, Condition cond2, int line) {
		this.cond1 = cond1;
		this.cond2 = cond2;
		this.line = line;
	}
	
	@Override
	public String toString() {
		return cond1.toString() + " || " + cond2.toString();
	}
}
