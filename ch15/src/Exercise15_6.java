import java.io.*;
import java.util.*;

public class Exercise15_6 {
	static String[] argArr;
	static File curDir;
	
	static {
		try {
			curDir = new File(System.getProperty("user.dir"));
		} catch(Exception e) {}
	}	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			try {
				String prompt = curDir.getCanonicalPath()+">>";
				System.out.print(prompt);
				
				String input = s.nextLine();
				
				input = input.trim();
				argArr = input.split(" +");
				
				String command = argArr[0].trim();
				
				if("".equals(command)) continue;
				
				command = command.toLowerCase();
				
				if(command.equals("q")) {
					System.exit(0);
				} else if(command.equals("cd")) {
					cd();
				} else {
					for(int i=0; i<args.length; i++)
						System.out.println(args[i]);
				}
			
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("입력 오류입니다.");
				s.close();
			}
			
		}
		
	}
	
	public static void cd() {
		if(argArr.length == 1) {
			System.out.println(curDir);
			return;
		} else if(argArr.length > 2) {
			System.out.println("USAGE : cd DIRECTORY");
			return;
		}
		
		String subDir = argArr[1];
		
		if(subDir.equals("..")) {
			curDir = curDir.getParentFile();
		} else if(subDir.equals(".")) {
			System.out.println(curDir);
		} else {
			File sDir = new File(curDir, subDir);
			
			if(sDir.exists() && sDir.isDirectory()) curDir = sDir;
			else {
				System.out.println("유효하지 않은 디렉터리입니다");
				return;
			}
		}
	}
	


}
