package Operations;

import java.util.List;

import model.GameClass;
import model.TestCase;

public class Evaluator{
	TestCase testcase;
	GameClass gameclass;

	public Evaluator(TestCase testcase, GameClass gameclass) {
		this.testcase = testcase;
		this.gameclass = gameclass;
	}

	public String getEvaluations() {
		String result = "";
		
		if(this.testcase != null){
			result = testcase.toString();
			
		}

		return result;
	}




}
