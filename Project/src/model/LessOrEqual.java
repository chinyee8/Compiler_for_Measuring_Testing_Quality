package model;

public class LessOrEqual extends Condition{
	public Mathematics left;
	public Mathematics right;
	
	public LessOrEqual(Mathematics left, Mathematics right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return left.toString() + " <= " + right.toString();
	}
}
