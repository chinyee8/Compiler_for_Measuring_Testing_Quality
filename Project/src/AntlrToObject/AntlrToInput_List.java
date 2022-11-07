package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.CallParamCharContext;
import antlr.exprParser.CallParamCondContext;
import antlr.exprParser.CallParamDoubleContext;
import antlr.exprParser.CallParamMathContext;
import antlr.exprParser.CallParamNumContext;
import antlr.exprParser.CallParamStringContext;
import antlr.exprParser.CallParamVarNameContext;
import model.CallParamChar;
import model.CallParamCond;
import model.CallParamDouble;
import model.CallParamMath;
import model.CallParamNum;
import model.CallParamString;
import model.CallParamVarName;
import model.Condition;
import model.Input_List;
import model.Mathematics;

public class AntlrToInput_List extends exprBaseVisitor<Input_List>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToInput_List(List<String> semanticErrors) {
		this.semanticErrors = new ArrayList<>();
	}
	
	@Override
	public Input_List visitCallParamMath(CallParamMathContext ctx) {
		AntlrToMathematics mVisitor = new AntlrToMathematics(semanticErrors);
		Mathematics m = mVisitor.visit(ctx.getChild(0));
		return new CallParamMath(m);
	}

	@Override
	public Input_List visitCallParamCond(CallParamCondContext ctx) {
		AntlrToCondition cVisitor = new AntlrToCondition(semanticErrors);
		Condition c = cVisitor.visit(ctx.getChild(0));
		return new CallParamCond(c);
	}

	@Override
	public Input_List visitCallParamVarName(CallParamVarNameContext ctx) {
		String varName = ctx.VAR_NAME().getText();
		return new CallParamVarName(varName);
	}

	@Override
	public Input_List visitCallParamNum(CallParamNumContext ctx) {
		String numText = ctx.NUM().getText();
		int num = Integer.parseInt(numText);
		return new CallParamNum(num);
	}

	@Override
	public Input_List visitCallParamChar(CallParamCharContext ctx) {
		String cString = ctx.CHAR().getText();
		char c = cString.charAt(0);
		return new CallParamChar(c);
	}

	@Override
	public Input_List visitCallParamString(CallParamStringContext ctx) {
		String s = ctx.STRING().getText();
		return new CallParamString(s);
	}

	@Override
	public Input_List visitCallParamDouble(CallParamDoubleContext ctx) {
		String doubText = ctx.DOUBLE().getText();
		double d = Double.parseDouble(doubText);
		return new CallParamDouble(d);
	}

}
