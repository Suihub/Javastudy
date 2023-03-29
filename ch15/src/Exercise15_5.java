import java.io.*;

public class Exercise15_5 {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("USAGE : java Exercise15_5 TARGET_FILE RESULT_FILE");
			System.exit(0);
		}
		
		String inputFile = args[0];
		String outputFile = args[1];
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(inputFile));
			HtmlTagFilterWriter output = new HtmlTagFilterWriter(new FileWriter(outputFile)); 
			
			int ch = 0;
			
			while((ch = input.read())!=-1)
				output.write(ch);
			
			input.close();
			output.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}

class HtmlTagFilterWriter extends FilterWriter{
	StringWriter tmp = new StringWriter();
	boolean inTag = false;
	
	HtmlTagFilterWriter(Writer out) {
		super(out);
	}
	
	public void write(int c) throws IOException{
		if(c == '<') inTag = true;

		if(inTag) tmp.write(c);
		else out.write(c);	
		
		if(c == '>') {
			inTag = false;
			tmp = new StringWriter();
		}
	}
	
	public void close() throws IOException{
		out.write(tmp.toString());
		super.close();
	}
	
}
