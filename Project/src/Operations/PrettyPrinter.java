package Operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PrettyPrinter{

	Evaluator ep;
	private AllDefCoverage allDef;
	private Map<Integer, List<String>> lines;
	private int totalTestNum;


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
		result += "<button onclick=\"text()\"> Original Code </button><br><br>\n";
		result += "<button onclick=\"statement()\"> Statement Coverage </button><br><br>\n";
		result += "<button onclick=\"condition()\"> Condition Coverage </button><br><br>\n";
		result += "<button onclick=\"allDef()\"> All-Defs Coverage </button><br><br>\n";
		
		//original code
		result += this.getOriginal(0);
		
		//for Condition
//		result += 
		
		//for Condition
//		result += 
		
		//all def coverage
		result += this.allDef.getString(0);
		
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
		
		
		
		result += "</script>";
		
		return result;
	}
	
	public String getOriginal(int testnum) {
		String result = "";
		
		result = "<p id=\"text\">\n";
		for(String s: lines.get(testnum)) {
			result += s +"<br>\n";
		}
		result += "</p><br>\n";
		
		return result;
	}

	public void addAllDefCoverage(AllDefCoverage alldef) {
		this.allDef = alldef;
	}



}

