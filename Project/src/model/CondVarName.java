package model;

public class CondVarName extends Condition{
	public String varName;
	
	public CondVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		return varName;
	}
}
