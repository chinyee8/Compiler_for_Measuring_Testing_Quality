package appAdd;

import model.GameClass;

public class Evaluator {
	GameClass gameclass;
	
	public Evaluator(GameClass gameclass) {
		this.gameclass = gameclass;
	}

	public String getEvaluations() {
		String result = "";
		
			result = gameclass.toString();
		
		return result;
	}
}
