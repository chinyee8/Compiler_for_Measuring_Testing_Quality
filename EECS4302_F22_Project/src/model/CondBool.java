package model;

public class CondBool extends Condition{
	public boolean bool;
	public int line;
	
	public CondBool(boolean bool, int line) {
		this.bool = bool;
		this.line = line;
	}
	
	@Override
	public String toString() {
		return Boolean.toString(bool);
	}
}
