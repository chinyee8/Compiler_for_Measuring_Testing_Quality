package model;

public class ValueBool extends Values {
	public boolean value;
	public ValueBool(boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "BOOLEAN";
	}
	
	@Override
	public Values getValues() {
		// TODO Auto-generated method stub
		return new ValueBool(value);
	}
}
