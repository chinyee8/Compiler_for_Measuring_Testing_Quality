package model;

public class Assignment {
	public String varName;
	public Expr expr;
	
	public Assignment(String varName, Expr expr) {
		this.varName = varName;
		this.expr = expr;
	}
	
	@Override
	public String toString() {
		return varName + " <- " + expr.toString();
	}
}
