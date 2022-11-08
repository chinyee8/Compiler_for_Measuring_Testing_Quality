package model;

public class GameClass{
	public String className;
	public GameBody body;
	
	public GameClass(String className, GameBody body) {
		this.className = className;
		this.body = body;
	}
	
	@Override
	public String toString() {
		String result = "";
		
			result = "game " + this.className + "[ ] !<br>";
			result += body.toString() + "<br>";
			result += "!";
			
		return result;
	}
}
