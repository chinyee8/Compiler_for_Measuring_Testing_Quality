package model;

public class GameClass extends Expression{
	public String className;
	
	public GameClass(String className) {
		this.className = className;
	}
	
	@Override
	public String toString() {
		String result = "";
		
			result = "game " + this.className + "[ ] !\n";
			
		return result;
	}
}
