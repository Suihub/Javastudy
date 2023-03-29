import java.io.*;

public class FileHead {

	public static void main(String[] args)
	{
		try {
			int line = Integer.parseInt(args[0]);
			String fileName = args[1];
			
			File file = new File(args[1]);
			
			if(!file.exists() || file.isDirectory()) 
				throw new NullPointerException(fileName + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String out = "";
			int i = 1;
			
			while((out = br.readLine())!=null && i<=line) {
				System.out.println(i + ":"+ out);
				i++;
			}
			
			br.close();
		} catch(NumberFormatException | ArrayIndexOutOfBoundsException ne) {
			System.out.println("USAGE : java FileHead 10 FINENAME");
		} catch(NullPointerException ne) {
			System.out.println(ne.getMessage());
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
