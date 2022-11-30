package model;

import java.util.HashMap;
import java.util.List;

public class Loop {
	public int iterationGoal;
	public List<String> semanticErrors;
	public HashMap<String, Values> variableMap;
	public List<MyMethodBody> myMethodBodyList;
	
	public Loop(int iterationGoal, List<MyMethodBody> body, List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.iterationGoal = iterationGoal;
		this.myMethodBodyList = body;
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	
}
