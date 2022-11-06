package model;

public class MathNumber extends Mathematics{
	int num;
	
	public MathNumber(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return Integer.toString(num);
	}
}
