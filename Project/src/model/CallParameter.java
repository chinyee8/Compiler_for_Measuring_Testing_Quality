package model;

import java.util.ArrayList;
import java.util.List;

public class CallParameter extends Call_Parameter {
	Input_List input;
	
	public CallParameter(Input_List input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return input.toString();
	}
	
	public List<String> getCallParams(){
		List<String> callparams = new ArrayList<>();
		
		callparams.add(((CallParamVarName)input).varName);
		
		return callparams;
	}
}
