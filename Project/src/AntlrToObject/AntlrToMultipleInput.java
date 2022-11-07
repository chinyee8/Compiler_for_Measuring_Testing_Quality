package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.MultipleInputContext;
import model.Input_List;
import model.MultipleInput;

public class AntlrToMultipleInput extends exprBaseVisitor<MultipleInput>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToMultipleInput(List<String> semanticErrors) {
		this.semanticErrors = new ArrayList<>();
	}

	@Override
	public MultipleInput visitMultipleInput(MultipleInputContext ctx) {
		AntlrToInput_List iVisitor = new AntlrToInput_List(semanticErrors);
		Input_List input = iVisitor.visit(ctx.getChild(0));
		return new MultipleInput(input);
	}


}
