package model;

import java.util.ArrayList;
import java.util.List;

public class SingleParam extends Parameter{
	Params params;
	
	public SingleParam(Params params) {
		this.params = params;
	}
	
	@Override
	public String toString() {
		return params.toString();
	}
	
	public List<String> orderOfParams() {
		// TODO Auto-generated method stub
		ArrayList<String> temp = new ArrayList<>();
		temp.add(this.params.varName);
		return temp;
	}
}
