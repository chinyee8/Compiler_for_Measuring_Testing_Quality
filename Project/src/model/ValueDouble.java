package model;

public class ValueDouble extends Values {
	double value;
	public ValueDouble(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Double.toString(value);
	}
}
