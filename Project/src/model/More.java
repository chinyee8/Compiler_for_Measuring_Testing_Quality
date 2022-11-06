package model;

public class More extends Condition{
	Mathematics math1;
	Mathematics math2;
	
	public More(Mathematics math1, Mathematics math2) {
		this.math1 = math1;
		this.math2 = math2;
	}
	
	@Override
	public String toString() {
		return math1.toString() + " > " + math2.toString();
	}
}
