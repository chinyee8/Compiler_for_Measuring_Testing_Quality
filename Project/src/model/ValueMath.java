package model;

public class ValueMath extends Values {
	public Mathematics math;
	
	public ValueMath(Mathematics math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return math.toString();
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		
		return "MATH";
	}
	
	public Values getValues() {
		
		return null;
	}
	
	private double getDouble(Mathematics m) {
		double result = 0.00;
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left / right;
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getDouble(a.math);
		}else if(m instanceof MathDouble) {
			MathDouble a = (MathDouble) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(a.val.getType().equals("DOUBLE")) {
				result = ((ValueDouble)a.val).value;
			}
		}
		
		return result;
	}

	public int getInt(Mathematics m) {
		int result = 0;
		
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left / right;
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getInt(a.math);
		}else if(m instanceof MathNumber) {
			MathNumber a = (MathNumber) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(a.val.getType().equals("INT")) {
				result = ((ValueNum)a.val).num;
			}
		}
			
		return result;
	}
}
