package model;

import java.util.List;

public class GameBody extends Expression{
	public List<Declaration> declList;
	public List<Assignment> assiList;
	public List<MyMethods> myMethodList;
	
	public GameBody(List<Declaration> declList, List<Assignment> assiList, List<MyMethods> myMethodList) {
		
		this.declList = declList;
		this.assiList = assiList;
		this.myMethodList = myMethodList;
		
	}

	@Override
	public String toString() {
		String result = "";
		
			for(Declaration d : this.declList) {
				result += d.toString() + "\n";
			}
			
			for(Assignment a : this.assiList) {
				result += a.toString() + "\n";
			}
			
			for(MyMethods m : this.myMethodList) {
				result += m.toString() + "\n";
			}
		
		return result;
	}
}
