package AntlrToObject;

import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.CallParamCharContext;
import antlr.exprParser.CallParamDoubleContext;
import antlr.exprParser.CallParamNumContext;
import antlr.exprParser.CallParamStringContext;
import antlr.exprParser.CallParamVarNameContext;
import model.CallParamChar;
import model.CallParamDouble;
import model.CallParamNum;
import model.CallParamString;
import model.CallParamVarName;
import model.Input_List;

public class AntlrToInput_List extends exprBaseVisitor<Input_List>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToInput_List(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
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
