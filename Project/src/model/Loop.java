package model;

import java.util.HashMap;
import java.util.List;

public class Loop {
	public int iterationGoal;
	public List<String> semanticErrors;
	public HashMap<String, Values> variableMap;
	public List<MyMethodBody> loopbody;
	public MyMethodBody body;
	
	public Loop(int iterationGoal, List<MyMethodBody> mb, MyMethodBody mb2, List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.iterationGoal = iterationGoal;
		this.loopbody = mb;
		this.body = mb2;
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	
}
