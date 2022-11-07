package model;

import java.util.List;

public class CallMultiParameter extends Call_Parameter {
	Input_List input;
	List<MultipleInput> multi_input;
	
	public CallMultiParameter(Input_List input,
							  List<MultipleInput> multi_input) {
		this.input = input;
		this.multi_input = multi_input;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for(MultipleInput m: multi_input) {
			result += m.toString();
		}
		
		return input.toString() + " " + result;
	}
}
