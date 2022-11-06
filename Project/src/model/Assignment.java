package model;

public class Assignment extends Expression{
	public String varName;
	public AssiExpr assiexpr;
	
	public Assignment(String name, AssiExpr assiexpr) {
		
		varName = name;
		this.assiexpr = assiexpr;
	}
	
	@Override
	public String toString() {
		return varName + " <- " + this.assiexpr.toString();
	}
}
