package model;

import appAdd.Expression;

public class PMulti extends Expression {
	String dataType;
	String varName;
	
	public PMulti(String dataType, String varName) {
		this.dataType = dataType;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		return dataType + " " + varName + ", ";
	}
}
