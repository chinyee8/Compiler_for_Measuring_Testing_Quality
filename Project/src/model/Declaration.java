package model;

public class Declaration {
	String varName;
	String dataType;
	
	public Declaration(String varName, String dataType) {
		this.varName = varName;
		this.dataType = dataType;
	}
	
	@Override
	public String toString() {
		return varName + " << " + dataType;
	}
}
