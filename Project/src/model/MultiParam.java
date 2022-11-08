package model;

import java.util.List;

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
}
