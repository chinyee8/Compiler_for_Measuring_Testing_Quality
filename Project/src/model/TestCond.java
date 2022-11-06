package model;

public class TestCond extends Input{
	Condition cond;
	
	public TestCond(Condition cond) {
		this.cond = cond;
	}
	
	@Override
	public String toString() {
		return cond.toString();
	}
}
