package Operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import model.MethodCall;
import model.Program;
import model.TestCase;
import model.Values;

public class PrettyPrinter{

	private AllDefCoverage allDef;
	private ConditionCoverage condCov;
	private AllCUsesCoverage allC;
	private Statement statement;
	private Original ori;
	private Map<MethodCall, Map<String, Values>> allMethodCalls;
	private Testcase test;


	public PrettyPrinter(Map<MethodCall, Map<String, Values>> allMethodCalls) {
		this.allMethodCalls = allMethodCalls;
	}

	public void prettyPrint( ) {
		try {
			File test = new File("index.html");
			test.createNewFile();
			System.out.println("File created in Project holder: index.html");
			FileWriter myWriter = new FileWriter("index.html");
			myWriter.write(getTest());
			myWriter.close();

			this.allDef.computeAllDef(); 
			
			for(int i = 0; i < this.allMethodCalls.size() ; i++) {
				File game = new File("game" + i + ".html");
				game.createNewFile();
				FileWriter myWriter2 = new FileWriter("game"+i+".html");
				myWriter2.write(getFunction(i));
				myWriter2.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getTestStyle() {
		String result = "";
		
		result += "<style>\n";

		result += "p{\n"
				+ "display: inline;\n"
				+ "}\n";

		result += "</style>\n";

		return result;
	}

	private String getTest() {
		String result ="";

		result +="<html>\n";

		//css
		result += getTestStyle();

		//html
		result += "<h1>TestCase</h1>";
		result += this.test.getString();

		//javascript
		result += this.getTestJS();
		
		result += "</html>";

		return result;
	}

	

	private String getTestJS() {
		String result = "";

		result = "<script>\n";

		

		result += "</script>";

		return result;
	}

	public String getGameStyle() {
		String result = "";
		result += "<style>\n";

		result += "p{\n"
				+ "display: inline;\n"
				+ "}\n";

		result += " u{\n"
				+ " color: red;\n"
				+ "}\n";

		result += "</style>\n";

		return result;
	}

	public String getFunction(int i) {
		String result ="";

		result +="<html>\n";

		//css
		result += getGameStyle();

		//html
		result += "<h1>Game Class</h1>";
		result += "<a href=\"index.html\"><button> TestCase </button></a>\n";
		result += "<button onclick=\"statement()\"> Statement Coverage </button>\n";
		result += "<button onclick=\"condition()\"> Condition Coverage </button>\n";
		result += "<button onclick=\"allDef()\"> All-Defs Coverage </button>\n";
		result += "<button onclick=\"allCUse()\"> All-C-Uses Coverage </button>\n";

		result += "<br><br>";

		result += "<div id=\"text\">\n" + this.ori.getString() + "</div>"; //original code

		result += "<div id=\"statement\" hidden>\n" + this.statement.getString(i) + "</div>"; //statement
		result += "<div id=\"condition\" hidden>\n" + this.getCondCoverageString() + "</div>"; //condition

		result += "<div id=\"allDef\" hidden>\n" + this.allDef.resultString.get(i) + "</div>\n"; //alldef
		for(String s: this.allDef.different.get(i)) {
			result+= s + "\n";
		}
		
		
		//		result += "<div id=\"allCUse\" hidden>\n" + this.allC.getString(0) + "</div>";

		//javascript
		result += this.getGameJS(i);

		result += "</html>";

		return result;
	}

	public String getGameJS(int i) {
		String result = "";

		result = "<script>\n";

		result += "function statement(){\n"
				+ "document.getElementById(\"text\").innerHTML = document.getElementById(\"statement\").innerHTML;\n"
				+ "}\n";

		result += "function condition(){\n"
				+ "document.getElementById(\"text\").innerHTML = document.getElementById(\"condition\").innerHTML;\n"
				+ "}\n";

		result += "function allDef(){\n"
				+ "document.getElementById(\"text\").innerHTML = document.getElementById(\"allDef\").innerHTML;\n"
				+ "}\n";

		result += "function allCUse(){\n"
				+ "document.getElementById(\"text\").innerHTML = document.getElementById(\"allCUse\").innerHTML;\n"
				+ "}\n";

		for(String s: this.allDef.javascript.get(i)) {
			result += s;
		}

		result += "</script>";

		return result;
	}


	public void addStatement(Statement s) {
		this.statement = s;		
	}

	public void addAllDefCoverage(AllDefCoverage alldef) {
		this.allDef = alldef;
	}

	public void addCondCoverage(ConditionCoverage condCov) {
		this.condCov = condCov;
	}

	public String getCondCoverageString() {
		return condCov.getPrint();
	}

	public void addAllCUseCoverage(AllCUsesCoverage allc) {
		this.allC = allc;		
	}

	public void addOriginal(Original ori) {
		this.ori = ori;
	}

	public void addTest(Testcase test) {
		this.test = test;
	}

}
