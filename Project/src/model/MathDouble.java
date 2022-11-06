package model;

public class MathDouble extends Mathematics{
	double num;
	
	public MathDouble(double num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return Double.toString(num);
	}
}
