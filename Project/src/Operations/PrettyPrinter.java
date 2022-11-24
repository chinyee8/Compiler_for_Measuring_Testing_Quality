package Operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PrettyPrinter{

	Evaluator ep;
	private AllDefCoverage allDef;
	private ConditionCoverage condCov;
	private Map<Integer, List<String>> lines;
	private int totalTestNum;
	private AllCUsesCoverage allC;
	private Statement statement;


	public PrettyPrinter(Evaluator ep, Map<Integer, List<String>> lines, int totalTestNum) {
		this.ep = ep;
		this.lines = lines;
		this.totalTestNum = totalTestNum;
	}

	public void prettyPrint( ) {
		try {
			File h = new File("index.html");
			h.createNewFile();
			//	            if (h.createNewFile()) {
			System.out.println("File created");
			FileWriter myWriter = new FileWriter("index.html");
			myWriter.write(getFunction());
			myWriter.close();
			System.out.println("successfully wrote to the file");
			//	            } else {
			//	                System.out.println("File already exist");
			//	            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getFunction() {
		String result ="";
		
		result +="<html>\n";
		
		//button
		result += "<button onclick=\"statement()\"> Statement Coverage </button>\n";
		result += "<button onclick=\"condition()\"> Condition Coverage </button>\n";
		result += "<button onclick=\"allDef()\"> All-Defs Coverage </button>\n";
		result += "<button onclick=\"allCUse()\"> All-C-Uses Coverage </button>\n";

		//original code
		result += this.getOriginal(0);
		
		//ControlFlow
		result += "<div id=\"statement\" hidden>\n" + this.statement.getString(0) + "</div>";
		result += "<div id=\"condition\" hidden>\n" + this.getCondCoverageString() + "</div>";
		
		//DataFlow
		result += "<div id=\"allDef\" hidden>\n" + this.allDef.getString(0) + "</div>";
		result += "<div id=\"allCUse\" hidden>\n" + this.allC.getString(0) + "</div>";
		
		//javascript
		result += this.getjsScript();
		
		result += "</html>";
		
		return result;
	}
	
	public String getjsScript() {
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
		
		
		result += "</script>";
		
		return result;
	}
	
	public String getOriginal(int testnum) {
		String result = "";
		
		result = "<p id=\"text\">";
		for(String s: lines.get(testnum)) {
			result += s +"<br>";
		}
		result += "</p><br>";
		
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



}
