package Operations;

import java.util.List;

import model.GameClass;
import model.TestCase;

public class Evaluator{
	GameClass gameclass;
	List<TestCase> testcases;
	
	public Evaluator(GameClass gameclass) {
		this.gameclass = gameclass;
	}

	public Evaluator(List<TestCase> testcases) {
		this.testcases = testcases;
	}

	public String getEvaluations() {
		String result = "";
		
			if(this.gameclass != null) {
				result = gameclass.toString();
			}else if(this.testcases.size() != 0){
				for(TestCase t: testcases) {
					result = t.toString() + "<br>";
				}
			}
		
		return result;
	}
}
