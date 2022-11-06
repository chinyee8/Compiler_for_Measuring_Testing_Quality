package model;

public class Assignment extends Expression{
	public String varName;
	public Expr assiexpr;
	
	public Assignment(String name, Expr assiexpr) {
		
		varName = name;
		this.assiexpr = assiexpr;
	}
	
	@Override
	public String toString() {
		return varName + " <- " + this.assiexpr.toString();
	}
}
