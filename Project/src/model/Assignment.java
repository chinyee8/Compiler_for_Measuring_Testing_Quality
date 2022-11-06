package model;

public class Assignment{
	public String varName;
	public Expr expr;
	
	public Assignment(String name, Expr expr) {
		varName = name;
		this.expr = expr;
	}
	
	public String toString() {
		return varName + " <- " + this.expr.toString();
	}
}
