package AntlrToObject;
import model.*;

import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.Token;

import Operations.ConditionCoverage;
import antlr.*;
import antlr.exprParser.*;

public class AntlrToCondition extends exprBaseVisitor<Condition> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	
	//Condition Coverage
	public ConditionCoverage condCov = null;
	
	public AntlrToCondition(List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	//Condition Coverage
	public AntlrToCondition(List<String> semanticErrors, HashMap<String, Values> variableMap, ConditionCoverage condCov) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.condCov = condCov;
	}

	@Override
	public Condition visitLessOrEqual(LessOrEqualContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		
		// Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(0) instanceof CondVarNameContext || ctx.getChild(2) instanceof CondVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(ctx.getText());
				} 
				else {
					condCov.appendResultString(null); // todo put "0" or "1"
				}
			}
		}
		
		return new LessOrEqual(left, right, line);
	}
	@Override
	public Condition visitNegation(NegationContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		Condition condition = visit(ctx.getChild(1));
		// Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(1) instanceof CondVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(ctx.getText());
				} 
				else if (condCov.isCalledMethod()) {
					String value = "";
					if (this.variableMap.containsKey(condition.toString())) {
						value = this.variableMap.get(condition.toString()).toString();
					}
					else {
						value = condCov.getMethodParam(condition.toString());
						if (value == null) {
							value = condition.toString();
						}
					}
					
					if (!(Boolean.parseBoolean(value))) {
						condCov.appendResultString("1"); // in case of true
					}
					else {
						condCov.appendResultString("0"); // in case of false
					}
					
				}
			}
		}
		return new Negation(condition, line);
	}
	@Override
	public Condition visitNotEqualTo(NotEqualToContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		Condition left = visit(ctx.getChild(0));
		Condition right = visit(ctx.getChild(2));
		
		//Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(0) instanceof CondVarNameContext || ctx.getChild(0) instanceof MathVarNameContext 
					|| ctx.getChild(2) instanceof CondVarNameContext || ctx.getChild(2) instanceof MathVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(ctx.getText());
				} 
				else if (condCov.isCalledMethod()) {
					String leftValue = "";
					String rightValue = "";
					if (this.variableMap.containsKey(left.toString())) {
						leftValue = this.variableMap.get(left.toString()).toString();
					}
					else {
						leftValue = condCov.getMethodParam(left.toString());
						if (leftValue == null) {
							leftValue = left.toString();
						}
					}
					if (this.variableMap.containsKey(right.toString())) {
						rightValue = this.variableMap.get(right.toString()).toString();
					}
					else {
						rightValue = condCov.getMethodParam(right.toString());
						if (rightValue == null) {
							rightValue = right.toString();
						}
					}
					if (Boolean.parseBoolean(leftValue) != Boolean.parseBoolean(rightValue) 
							|| Double.parseDouble(leftValue) != Double.parseDouble(rightValue)) {
						condCov.appendResultString("1"); // in case of true
					}
					else {
						condCov.appendResultString("0"); // in case of false
					}
					
				}
			}
		}
		return new NotEqualTo(left, right, line);
	}
	@Override
	public Condition visitCondVarName(CondVarNameContext ctx) {
		Token token = ctx.VAR_NAME().getSymbol();
		int line = token.getLine();
		String varName = ctx.getChild(0).getText();
		// Condition Coverage
		if (condCov != null) {
			
			if (condCov.isComponentState()) {
				condCov.addComponent(ctx.getText());
			}
			else if (condCov.isCalledMethod()) {
				String value = "";
				if (this.variableMap.containsKey(varName.toString())) {
					value = this.variableMap.get(varName.toString()).toString();
				}
				else {
					value = condCov.getMethodParam(varName.toString());
					if (value == null) {
						value = varName.toString();
					}
				}
				
				if ((Boolean.parseBoolean(value))) {
					condCov.appendResultString("1"); // in case of true
				}
				else {
					condCov.appendResultString("0"); // in case of false
				}
				
			}
		}
		
		return new CondVarName(varName, line);
	}
	@Override
	public Condition visitCondEqual(CondEqualContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		// Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(0) instanceof CondVarNameContext || ctx.getChild(0) instanceof MathVarNameContext 
					|| ctx.getChild(2) instanceof CondVarNameContext || ctx.getChild(2) instanceof MathVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(condCov.getCurMethod() + "." + ctx.getText());
				} 
				else if (condCov.isCalledMethod()) {
					String leftValue = "";
					String rightValue = "";
					if (this.variableMap.containsKey(left.toString())) {
						leftValue = this.variableMap.get(left.toString()).toString();
					}
					else {
						leftValue = condCov.getMethodParam(left.toString());
						if (leftValue == null) {
							leftValue = left.toString();
						}
					}
					if (this.variableMap.containsKey(right.toString())) {
						rightValue = this.variableMap.get(right.toString()).toString();
					}
					else {
						rightValue = condCov.getMethodParam(right.toString());
						if (rightValue == null) {
							rightValue = right.toString();
						}
					}
					if (leftValue.equals(rightValue)) {
						condCov.appendResultString("1"); // in case of true
					}
					else {
						condCov.appendResultString("0"); // in case of false
					}
					
				}
			}
		}
		return new CondEqual(left, right, line);
	}
	@Override
	public Condition visitEqualTo(EqualToContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		Condition left = visit(ctx.getChild(0));
		Condition right = visit(ctx.getChild(2));
		
		// Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(0) instanceof CondVarNameContext || ctx.getChild(0) instanceof MathVarNameContext 
					|| ctx.getChild(2) instanceof CondVarNameContext || ctx.getChild(2) instanceof MathVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(ctx.getText());
				} 
				else if (condCov.isCalledMethod()) {
					String leftValue = "";
					String rightValue = "";
					if (this.variableMap.containsKey(left.toString())) {
						leftValue = this.variableMap.get(left.toString()).toString();
					}
					else {
						leftValue = condCov.getMethodParam(left.toString());
						if (leftValue == null) {
							leftValue = left.toString();
						}
					}
					if (this.variableMap.containsKey(right.toString())) {
						rightValue = this.variableMap.get(right.toString()).toString();
					}
					else {
						rightValue = condCov.getMethodParam(right.toString());
						if (rightValue == null) {
							rightValue = right.toString();
						}
					}
					if (leftValue.equals(rightValue)) {
						condCov.appendResultString("1"); // in case of true
					}
					else {
						condCov.appendResultString("0"); // in case of false
					}
					
				}
			}
		}
		return new EqualTo(left, right, line);
	}
	@Override
	public Condition visitMore(MoreContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		
		// Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(0) instanceof CondVarNameContext || ctx.getChild(0) instanceof MathVarNameContext 
					|| ctx.getChild(2) instanceof CondVarNameContext || ctx.getChild(2) instanceof MathVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(ctx.getText());
				} 
				else if (condCov.isCalledMethod()) {
					String leftValue = "";
					String rightValue = "";
					if (this.variableMap.containsKey(left.toString())) {
						leftValue = this.variableMap.get(left.toString()).toString();
					}
					else {
						leftValue = condCov.getMethodParam(left.toString());
						if (leftValue == null) {
							leftValue = left.toString();
						}
					}
					if (this.variableMap.containsKey(right.toString())) {
						rightValue = this.variableMap.get(right.toString()).toString();
					}
					else {
						rightValue = condCov.getMethodParam(right.toString());
						if (rightValue == null) {
							rightValue = right.toString();
						}
					}
					if (Double.parseDouble(leftValue) > Double.parseDouble(rightValue)) {
						condCov.appendResultString("1"); // in case of true
					}
					else {
						condCov.appendResultString("0"); // in case of false
					}
					
				}
			}
		}
		
		return new More(left, right, line);
	}
	@Override
	public Condition visitDisjunction(DisjunctionContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		Condition left = visit(ctx.getChild(0));
		Condition right = visit(ctx.getChild(2));
		// Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(0) instanceof CondVarNameContext  
					|| ctx.getChild(2) instanceof CondVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(ctx.getText());
				} 
				else if (condCov.isCalledMethod()) {
					String leftValue = "";
					String rightValue = "";
					if (this.variableMap.containsKey(left.toString())) {
						leftValue = this.variableMap.get(left.toString()).toString();
					}
					else {
						leftValue = condCov.getMethodParam(left.toString());
						if (leftValue == null) {
							leftValue = left.toString();
						}
					}
					if (this.variableMap.containsKey(right.toString())) {
						rightValue = this.variableMap.get(right.toString()).toString();
					}
					else {
						rightValue = condCov.getMethodParam(right.toString());
						if (rightValue == null) {
							rightValue = right.toString();
						}
					}
					if (Boolean.parseBoolean(leftValue) || Boolean.parseBoolean(rightValue)) {
						condCov.appendResultString("1"); // in case of true
					}
					else {
						condCov.appendResultString("0"); // in case of false
					}
					
				}
			}
		}
		return new Disjunction(left, right, line);
	}
	@Override
	public Condition visitCondBool(CondBoolContext ctx) {
		Token token = ctx.BOOL().getSymbol();
		int line = token.getLine();
		String temp = ctx.getChild(0).getText();
		boolean res = false;
		if(temp.equals("TRUE")) {
			res = true;
		}
		else if (temp.equals("FALSE")) {
			res = false;
		}
		
		return new CondBool(res, line);
	}
	@Override
	public Condition visitMoreOrEqual(MoreOrEqualContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		// Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(0) instanceof CondVarNameContext || ctx.getChild(0) instanceof MathVarNameContext 
					|| ctx.getChild(2) instanceof CondVarNameContext || ctx.getChild(2) instanceof MathVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(ctx.getText());
				} 
				else if (condCov.isCalledMethod()) {
					String leftValue = "";
					String rightValue = "";
					if (this.variableMap.containsKey(left.toString())) {
						leftValue = this.variableMap.get(left.toString()).toString();
					}
					else {
						leftValue = condCov.getMethodParam(left.toString());
						if (leftValue == null) {
							leftValue = left.toString();
						}
					}
					if (this.variableMap.containsKey(right.toString())) {
						rightValue = this.variableMap.get(right.toString()).toString();
					}
					else {
						rightValue = condCov.getMethodParam(right.toString());
						if (rightValue == null) {
							rightValue = right.toString();
						}
					}
					if (Double.parseDouble(leftValue) >= Double.parseDouble(rightValue)) {
						condCov.appendResultString("1"); // in case of true
					}
					else {
						condCov.appendResultString("0"); // in case of false
					}
					
				}
			}
		}
		return new MoreOrEqual(left, right, line);
	}
	@Override
	public Condition visitCondNotEqual(CondNotEqualContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		// Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(0) instanceof CondVarNameContext || ctx.getChild(0) instanceof MathVarNameContext 
					|| ctx.getChild(2) instanceof CondVarNameContext || ctx.getChild(2) instanceof MathVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(ctx.getText());
				} 
				else if (condCov.isCalledMethod()) {
					String leftValue = "";
					String rightValue = "";
					if (this.variableMap.containsKey(left.toString())) {
						leftValue = this.variableMap.get(left.toString()).toString();
					}
					else {
						leftValue = condCov.getMethodParam(left.toString());
						if (leftValue == null) {
							leftValue = left.toString();
						}
					}
					if (this.variableMap.containsKey(right.toString())) {
						rightValue = this.variableMap.get(right.toString()).toString();
					}
					else {
						rightValue = condCov.getMethodParam(right.toString());
						if (rightValue == null) {
							rightValue = right.toString();
						}
					}
					if (!(leftValue.equals(rightValue))) {
						condCov.appendResultString("1"); // in case of true
					}
					else {
						condCov.appendResultString("0"); // in case of false
					}
					
				}
			}
		}
		return new CondNotEqual(left, right, line);
	}
	@Override
	public Condition visitConjunction(ConjunctionContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		Condition left = visit(ctx.getChild(0));
		Condition right = visit(ctx.getChild(2));
		// Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(0) instanceof CondVarNameContext || ctx.getChild(0) instanceof MathVarNameContext 
					|| ctx.getChild(2) instanceof CondVarNameContext || ctx.getChild(2) instanceof MathVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(ctx.getText());
				} 
				else if (condCov.isCalledMethod()) {
					String leftValue = "";
					String rightValue = "";
					if (this.variableMap.containsKey(left.toString())) {
						leftValue = this.variableMap.get(left.toString()).toString();
					}
					else {
						leftValue = condCov.getMethodParam(left.toString());
						if (leftValue == null) {
							leftValue = left.toString();
						}
					}
					if (this.variableMap.containsKey(right.toString())) {
						rightValue = this.variableMap.get(right.toString()).toString();
					}
					else {
						rightValue = condCov.getMethodParam(right.toString());
						if (rightValue == null) {
							rightValue = right.toString();
						}
					}
					if (Boolean.parseBoolean(leftValue) && Boolean.parseBoolean(rightValue)) {
						condCov.appendResultString("1"); // in case of true
					}
					else {
						condCov.appendResultString("0"); // in case of false
					}
					
				}
			}
		}
		return new Conjunction(left, right, line);
	}
	@Override
	public Condition visitCondParenthesis(CondParenthesisContext ctx) {
		Condition temp = visit(ctx.getChild(1));
		return new CondParenthesis(temp);
	}
	@Override
	public Condition visitLess(LessContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		// Condition Coverage
		if (condCov != null) {
			if (ctx.getChild(0) instanceof CondVarNameContext || ctx.getChild(0) instanceof MathVarNameContext 
					|| ctx.getChild(2) instanceof CondVarNameContext || ctx.getChild(2) instanceof MathVarNameContext) {
				if (condCov.isComponentState()) {
					condCov.addComponent(ctx.getText());
				} 
				else if (condCov.isCalledMethod()) {
					String leftValue = "";
					String rightValue = "";
					if (this.variableMap.containsKey(left.toString())) {
						leftValue = this.variableMap.get(left.toString()).toString();
					}
					else {
						leftValue = condCov.getMethodParam(left.toString());
						if (leftValue == null) {
							leftValue = left.toString();
						}
					}
					if (this.variableMap.containsKey(right.toString())) {
						rightValue = this.variableMap.get(right.toString()).toString();
					}
					else {
						rightValue = condCov.getMethodParam(right.toString());
						if (rightValue == null) {
							rightValue = right.toString();
						}
					}
					if (Double.parseDouble(leftValue) < Double.parseDouble(rightValue)) {
						condCov.appendResultString("1"); // in case of true
					}
					else {
						condCov.appendResultString("0"); // in case of false
					}
					
				}
			}
		}
		return new Less(left, right, line);
	}
	
	
}
