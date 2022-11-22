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
		result += "<button onclick=\"allDef()\">All-Def</button><br><br>\n";
		
		result += this.getOriginal(0);
		result += this.allDef.getString(0);
		
		result += this.getjsScript();
		
		result += "</html>";
		
		return result;
	}
	
	public String getjsScript() {
		String result = "";
		
		result = "<script>\n";
		
		result += "function allDef(){\n"
				+ "document.getElementById(\"text\").innerHTML = document.getElementById(\"allDef\").innerHTML;\n"
				+ "}";
		
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

	public void addAllDefCoverage(AllDefCoverage alldef) {
		this.allDef = alldef;
	}



}

