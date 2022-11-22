package model;

public class CondBool extends Condition{
	public boolean bool;
	
	public CondBool(boolean bool) {
		this.bool = bool;
	}
	
	@Override
	public String toString() {
		return Boolean.toString(bool);
	}
}
