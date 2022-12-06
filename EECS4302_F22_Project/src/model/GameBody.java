package model;

import java.util.List;

//should i extend GameClass?
public class GameBody{	
	public List<Declaration> declList;
	public List<Assignment> assiList;
	public List<MyMethods> myMethodList;
	
	public GameBody(List<Declaration> declList,
					List<Assignment> assiList, 
					List<MyMethods> myMethodList) {
		this.declList = declList;
		this.assiList = assiList;
		this.myMethodList = myMethodList;
	}
	
	@Override
	public String toString() {
		String result = "";
		
			for(Declaration d : this.declList) {
				result += d.toString() + "<br>";
			}
			
			for(Assignment a : this.assiList) {
				result += a.toString() + "<br>";
			}
			
			for(MyMethods m : this.myMethodList) {
				result += m.toString() + "<br>";
			}
		
		return result;
	}
}
