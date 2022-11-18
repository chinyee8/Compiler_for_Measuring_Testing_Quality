package Operations;

import java.util.List;

import model.GameClass;
import model.TestCase;

public class Evaluator{
	GameClass gameclass;
	TestCase testcase;

	public Evaluator(GameClass gameclass) {
		this.gameclass = gameclass;
	}

	public Evaluator(TestCase testcase) {
		this.testcase = testcase;
	}

	public String getEvaluations() {
		String result = "";

		if(this.gameclass != null) {
			result = gameclass.toString();
		}else if(this.testcase != null){
			result = testcase.toString();

		}

		return result;
	}




}
