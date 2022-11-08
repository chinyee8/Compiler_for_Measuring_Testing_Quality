package model;

public class ValueBool extends Values {
	boolean value;
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
}
