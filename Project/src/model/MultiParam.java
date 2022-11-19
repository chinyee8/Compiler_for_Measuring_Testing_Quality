package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MultiParam extends Parameter{
	 Params param;
	 List<MultiParamChild> multi_param;
	
	public MultiParam(Params param, List<MultiParamChild> multi_param) {
		this.param = param;
		this.multi_param = multi_param;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for(MultiParamChild m  : multi_param) {
			result += m.toString();
		}
		
		return param.toString() + " " + result;
	}
	
	public Map<String, String> getParams() {
		Map<String, String> params = new LinkedHashMap<>();
		
		params.put(param.varName, param.dataType);
		for(MultiParamChild i : multi_param) {
			params.put(i.params.varName, i.params.dataType);
		}
		
		return params;
	}
}
