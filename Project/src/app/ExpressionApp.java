package app;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import AntlrToObject.AntlrToProgram;
import antlr.exprLexer;
import antlr.exprParser;
import appAdd.ErrorListener;
import appAdd.ExpressionProcessor;
import model.Program;

public class ExpressionApp {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.print("file name");
		}
		else {
			String fileName = args[0];
			exprParser parser =getParser(fileName);
			ParseTree AST = parser.prog();
			
			if(ErrorListener.hasError) {
				
			}
			else {
				AntlrToProgram progVisitor = new AntlrToProgram();
				Program prog = progVisitor.visit(AST);
				if (progVisitor.semanticErrors.isEmpty()) {
					ExpressionProcessor ep = new ExpressionProcessor(prog.expressions);
					for(String evaluation: ep.getEvaluationResults()) {
						System.out.println(evaluation);
					}
				}
				else {
					for(String err: progVisitor.semanticErrors) {
						System.out.println(err);
					}
				}			
			}

		}
	}
	
	private static exprParser getParser(String fileName) {
		exprParser parser = null;
		
		try {
			CharStream input = CharStreams.fromFileName(fileName);			
			exprLexer lexer = new exprLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new exprParser(tokens);
			
			 parser.removeErrorListeners();
			 parser.addErrorListener(new ErrorListener());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parser;

		
		
	}

}
