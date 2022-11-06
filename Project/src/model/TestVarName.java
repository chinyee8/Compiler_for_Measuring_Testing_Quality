package model;

public class TestVarName extends Input{
	String varName;
	
	public TestVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		return this.varName;
	}
}
