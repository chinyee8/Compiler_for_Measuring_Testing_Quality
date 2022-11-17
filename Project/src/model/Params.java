package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Params extends Parameter{
	String dataType;
	String varName;
	
	public Params(String dataType, String varName) {
		this.dataType = dataType;
		this.varName = varName;
	}
	@Override
	public String toString() {
		return dataType + " " + varName;
	}
	
	public Map<String, String> getParams() {
		Map<String, String> params = new LinkedHashMap<>();
		
		params.put(varName, dataType);
		
		return params;
	}
}
