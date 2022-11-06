package model;

import java.util.ArrayList;
import java.util.List;

public class GameBody {
	public List<Declaration> declList;
	public List<Assignment> assiList;
	public List<MyMethod> myMethodList;
	
	public GameBody() {
		
		declList = new ArrayList<>();
		assiList = new ArrayList<>();
		myMethodList = new ArrayList<>();
		
	}
	
	public void addDecl(Declaration decl) {
		
		declList.add(decl);
		
	}
	
	public void addAssi(Assignment assi) {
		
		assiList.add(assi);
		
	}

	public void addMyMethod(MyMethod myM) {
	
		myMethodList.add(myM);
	
	}
}
