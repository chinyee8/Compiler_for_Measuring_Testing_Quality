package model;

public class MyParameter extends Parameter{
	String dataType;
	String varName;
	
	public MyParameter(String dataType, String varName) {
		this.dataType = dataType;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		return dataType + " " + varName;
	}
}
