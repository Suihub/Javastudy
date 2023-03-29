import java.io.*;

public class HexaViewer {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java HexaViewer FILENAME");
			System.exit(0);
		}
		
		try {
			String fileName = args[0];
			
			FileInputStream fis = new FileInputStream(fileName);
			PrintStream ps = new PrintStream(System.out);
	
			int data = 0;
			
			while((data = fis.read())!=-1) {
				ps.printf("%2x ", data);
			}
			
			fis.close();
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
