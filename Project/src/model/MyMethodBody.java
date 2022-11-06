package model;

import java.util.ArrayList;
import java.util.List;

public class MyMethodBody {
	public List<Declaration> declList;
	public List<Assignment> assiList;
	public List<IfStatement> ifStatList;
	public List<TestMethodCall> testMethodList;
	
	public MyMethodBody() {
		declList = new ArrayList<>();
		assiList = new ArrayList<>();
		ifStatList = new ArrayList<>();
		testMethodList = new ArrayList<>();
	}
	
	public void addDecl(Declaration decl) {
		
		declList.add(decl);
		
	}
	
	public void addAssi(Assignment assi) {
		
		assiList.add(assi);
		
	}

	public void addIfStatement(IfStatement ifst) {
	
		ifStatList.add(ifst);
	
	}
	
	public void addTestMethodCall(TestMethodCall test) {
		
		testMethodList.add(test);
	
	}
}
