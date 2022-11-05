package model;

import antlr.exprBaseVisitor;
import antlr.exprParser.ProgramContext;

public class AntlrToProgram extends exprBaseVisitor<Program>{

	@Override
	public Program visitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub
		return super.visitProgram(ctx);
	}

}
