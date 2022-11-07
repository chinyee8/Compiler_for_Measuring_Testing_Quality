package model;

public class Values extends Expr  {
	Value_List value;
	
	public Values(Value_List value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
