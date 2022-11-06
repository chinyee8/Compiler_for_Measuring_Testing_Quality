package model;

public class CondVarName extends Condition{
	String varName;
	
	public CondVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		return varName;
	}
}
