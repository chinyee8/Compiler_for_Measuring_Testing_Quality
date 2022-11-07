package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.CallEmptyParameterContext;
import antlr.exprParser.CallMultiParameterContext;
import antlr.exprParser.CallParameterContext;
import model.CallEmptyParameter;
import model.CallMultiParameter;
import model.CallParameter;
import model.Call_Parameter;
import model.Input_List;
import model.MultipleInput;

public class AntlrToCall_Parameter extends exprBaseVisitor<Call_Parameter> {
		public List<String> semanticErrors;
		public List<Integer> linesCovered;
		
		public AntlrToCall_Parameter(List<String> semanticErrors) {
			this.semanticErrors = new ArrayList<>();
		}

		@Override
		public Call_Parameter visitCallParameter(CallParameterContext ctx) {
			AntlrToInput_List iVisitor = new AntlrToInput_List(semanticErrors);
			Input_List input = iVisitor.visit(ctx.getChild(0));
			return new CallParameter(input);
		}

		@Override
		public Call_Parameter visitCallMultiParameter(CallMultiParameterContext ctx) {
			AntlrToInput_List iVisitor = new AntlrToInput_List(semanticErrors);
			Input_List input = iVisitor.visit(ctx.getChild(0));
			
			AntlrToMultipleInput mVisitor = new AntlrToMultipleInput(semanticErrors);
			List<MultipleInput> multiInput = new ArrayList<>();
			for(int i = 1; i < ctx.getChildCount(); i++ ) {
				multiInput.add(mVisitor.visit(ctx.getChild(i)));
			}
			
			return new CallMultiParameter(input, multiInput);
		}

		@Override
		public Call_Parameter visitCallEmptyParameter(CallEmptyParameterContext ctx) {
			return new CallEmptyParameter();
		}

}
