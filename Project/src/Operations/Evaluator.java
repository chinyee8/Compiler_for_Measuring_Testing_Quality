package Operations;

import model.GameClass;
import model.TestCase;

public class Evaluator{
	GameClass gameclass;
	TestCase testcase;

	public Evaluator(TestCase testcase, GameClass gameclass) {
		this.gameclass = gameclass;
		this.testcase = testcase;
	}

	public String getEvaluations() {
		String result = "";
		
		if(this.gameclass != null){
			result = gameclass.toString();
			
		}

		return result;
	}




}
