package model;

public class ValueDouble extends Values {
	public double value;
	public ValueDouble(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Double.toString(value);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "DOUBLE";
	}

	public double getNum() {
		return value;
	}

	@Override
	public Values getValues() {
		// TODO Auto-generated method stub
		return new ValueDouble(value);
	}
}
