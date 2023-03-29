import java.io.*;
import java.util.*;

public class FileMergeTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("USAGE : java FileMergeTest MERGE_FILENAME FILENAME1 FILENAME2 ...");
			System.exit(0);
		}
		
		String fileName = args[0];
        
		@SuppressWarnings("rawtypes")
		Vector v = new Vector();
		
		try {
			for(int i=1; i<args.length; i++) {
				File f = new File(args[i]);
				
				if(f.exists()) {
					v.add(new FileInputStream(f));
				} else {
					System.out.println(f.getName()+"은 존재하지 않는 파일입니다.");
					System.exit(0);
				}
			}
			
			SequenceInputStream input = new SequenceInputStream(v.elements());
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int data = 0;
			
			while((data = input.read())!= -1) {
				bos.write(data);
			}
			
			input.close();
			bos.close();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
