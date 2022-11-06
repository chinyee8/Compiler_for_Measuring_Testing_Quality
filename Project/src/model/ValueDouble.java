package model;

public class ValueDouble extends AssiExprValues {
	double value;
	public ValueDouble(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Double.toString(value);
	}
}
