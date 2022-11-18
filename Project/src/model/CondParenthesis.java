package model;

public class CondParenthesis extends Condition{
	public Condition cond;
	
	public CondParenthesis(Condition cond) {
		this.cond = cond;
	}
	
	@Override
	public String toString() {
		return "( " + cond.toString() + " )";
	}
}
