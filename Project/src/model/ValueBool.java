package model;

public class ValueBool extends Value_List {
	boolean value;
	public ValueBool(boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}
}
