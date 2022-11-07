package model;

public class MultiParam extends Parameter{
	 Params param;
	 MultiParamChild multi_param;
	
	public MultiParam(Params param, MultiParamChild multi_param) {
		this.param = param;
		this.multi_param = multi_param;
	}
	
	@Override
	public String toString() {
		return param.toString() + " " + multi_param.toString();
	}
}
