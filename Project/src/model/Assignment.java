package model;

public class Assignment {
	public String varName;
	public Expr expr;
	public boolean covered;
	
	public Assignment(String varName, Expr expr) {
		this.varName = varName;
		this.expr = expr;
		covered = false;
	}
	
	@Override
	public String toString() {
		return varName + " <- " + expr.toString();
	}
}
