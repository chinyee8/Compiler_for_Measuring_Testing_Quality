package model;

public class Assignment {
	public String varName;
	public Expr expr;
	public boolean covered;
	public int line;
	
	public Assignment(String varName, Expr expr, int line) {
		this.varName = varName;
		this.expr = expr;
		this.line = line;
		covered = false;
	}
	
	@Override
	public String toString() {
		return varName + " <- " + expr.toString();
	}

	public void setCovered(boolean b) {
		this.covered = b;
	}
}
