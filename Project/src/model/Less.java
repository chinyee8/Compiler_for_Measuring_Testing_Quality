package model;

public class Less extends Condition{
	public Mathematics math1;
	public Mathematics math2;
	
	public Less(Mathematics math1, Mathematics math2) {
		this.math1 = math1;
		this.math2 = math2;
	}
	
	@Override
	public String toString() {
		return math1.toString() + " < " + math2.toString();
	}
}
