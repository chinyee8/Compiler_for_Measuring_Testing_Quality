package Operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrettyPrinter implements Visitor{
	private String result;

	public PrettyPrinter() {
		this.result = "";
	}
	
	public String result() {
		return this.result;
	}
}

/*
 *Evaluator ep;
	
	public PrettyPrinter(Evaluator ep) {
		this.ep = ep;
	}
	
	public void prettyPrint( ) {
		 try {
	            File h = new File("index.html");
	            h.createNewFile();
//	            if (h.createNewFile()) {
	                System.out.println("File created");
	                FileWriter myWriter = new FileWriter("index.html");
	                String result = ep.getEvaluations();
	                myWriter.write("<html> <body>");
	                myWriter.write(result);
	                myWriter.write("</body> </html>");
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
 * */

