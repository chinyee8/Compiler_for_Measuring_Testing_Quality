package Operations;

import model.Assignment;
import model.Declaration;
import model.Expr;
import model.Program;
import model.ReturnMethodCall;
import model.TestCase;
import model.TestMethodCall;
import model.Values;

public class Testcase {
	private Program testProg;

	public Testcase(Program testProg) {
		this.testProg = testProg;
	}
	
	public String getString() {
		String result ="";
		
		TestCase t = this.testProg.testcase;
		
		result += "test " + t.testName + " !<br>";
		
		for(Declaration d : t.decl) {
			result +=  "&emsp;" + d.varName + " << " + d.dataType + "<br>";
		}
		
		if(t.decl.size()>0 && t.assi.size()>0) {
			result += "<br>";
		}
		
//		 int total = 0;
//		for(Assignment a: t.assi) {
//			if(a.expr instanceof ReturnMethodCall) {
//				total++;
//			}
//		}
		
//		int i = total-1;
		int i = 0;
		for(Assignment a : t.assi) {
			if(a.expr instanceof Values) {
				result += "&emsp;" + a.varName + " <- " + a.expr + "<br>";
			}else if(a.expr instanceof ReturnMethodCall) {
				result += "&emsp;" + a.varName + " <- " + "<a href=\"game"+i+".html\"><p><mark class=\"testcaseclick\">" + a.expr + "</mark></p></a>" + "<br>";
				i++;
			}
		}
		
		if(t.assi.size()>0 && t.t_method_call.size()>0) {
			result += "<br>";
		}else if(t.decl.size()>0 && t.t_method_call.size()>0 && t.assi.size()==0) {
			result += "<br>";
		}
		
		for(TestMethodCall tm : t.t_method_call) {
			result += "&emsp;" + tm.toString();
		}
		
		result += "!";
		
		return result;
	}
}
