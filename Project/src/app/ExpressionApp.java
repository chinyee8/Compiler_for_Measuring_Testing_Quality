package app;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import AntlrToObject.AntlrToProgram;
import Operations.ErrorListener;
import Operations.Evaluator;
import Operations.PrettyPrinter;
import antlr.exprLexer;
import antlr.exprParser;
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
					if(prog.gameclass != null) {
						Evaluator ep = new Evaluator(prog.gameclass);
						PrettyPrinter printer = new PrettyPrinter(ep);
						printer.prettyPrint();
					}else if(prog.testcases.size() != 0) {
						Evaluator ep = new Evaluator(prog.testcases);
						PrettyPrinter printer = new PrettyPrinter(ep);
						printer.prettyPrint();
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
