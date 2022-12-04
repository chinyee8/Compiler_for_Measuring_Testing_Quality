package model;

import java.util.HashMap;
import java.util.List;

public class Loop {
	public int iterationGoal;
	public List<String> semanticErrors;
	public HashMap<String, Values> variableMap;
	public MyMethodBody loopbody;
	
	public Loop(int iterationGoal, MyMethodBody mb, List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.iterationGoal = iterationGoal;
		this.loopbody = mb;
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	
}
