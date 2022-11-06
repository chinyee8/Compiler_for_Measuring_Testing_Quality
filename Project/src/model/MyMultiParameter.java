package model;

import java.util.List;

public class MyMultiParameter extends Parameter{
	List<PMulti> list;
	String dataType;
	String varName;
	
	public MyMultiParameter(List<PMulti> list, String dataType, String varName) {
		this.list = list;
		this.dataType = dataType;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for(PMulti p: list) {
			result += p.toString() + " ";
		}
		
		result += dataType + " " + varName;
		
		return result;
	}
}
