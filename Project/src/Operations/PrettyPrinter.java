package Operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PrettyPrinter{

	private AllDefCoverage allDef;
	private ConditionCoverage condCov;
	private int totalTestNum;
	private AllCUsesCoverage allC;
	private Statement statement;
	private Original ori;


	public PrettyPrinter(int totalTestNum) {
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
	
	public String getStyle() {
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
	
	public String getFunction() {
		String result ="";
		
		result +="<html>\n";
		
		result += getStyle();
		
		//button
		result += "<button onclick=\"statement()\"> Statement Coverage </button>\n";
		result += "<button onclick=\"condition()\"> Condition Coverage </button>\n";
		result += "<button onclick=\"allDef()\"> All-Defs Coverage </button>\n";
		result += "<button onclick=\"allCUse()\"> All-C-Uses Coverage </button>\n";
		
		result += "<br>";

		//original code
		result += "<div id=\"text\">\n" + this.ori.getString() + "</div>";
		
		//ControlFlow
		result += "<div id=\"statement\" hidden>\n" + this.statement.getString(0) + "</div>";
		result += "<div id=\"condition\" hidden>\n" + this.getCondCoverageString() + "</div>";
		
		//DataFlow
		this.allDef.computeAllDef();
		result += "<div id=\"allDef\" hidden>\n" + this.allDef.resultString.get(0) + "</div>\n";
		for(String s: this.allDef.different.get(0)) {
			result+= s + "\n";
		}
//		result += "<div id=\"allCUse\" hidden>\n" + this.allC.getString(0) + "</div>";
		
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
		
		for(String s: this.allDef.javascript.get(0)) {
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



}
