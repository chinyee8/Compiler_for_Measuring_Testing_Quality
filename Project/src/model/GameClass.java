package model;

public class GameClass extends Game{
	public String className;
	public GameBody body;
	
	public GameClass(String className, GameBody body) {
		this.className = className;
		this.body = body;
	}
	
	@Override
	public String toString() {
		String result = "";
		
			result = "game " + this.className + "[ ] !\n";
			result += body.toString() + "\n";
			result += "!";
			
		return result;
	}
}
