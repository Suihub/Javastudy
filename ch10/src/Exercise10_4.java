import java.util.*;
import java.text.*;

public class Exercise10_4 {

	public static void main(String[] args) {
		String pattern = "yyyy/MM/dd";
		SimpleDateFormat sdFormat = new SimpleDateFormat(pattern);
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdFormat2 = new SimpleDateFormat("�Է��Ͻ� ��¥�� E�����Դϴ�.");
		
		while(true) {
			System.out.println("��¥�� "+pattern+"�� �������� �Է����ּ���.(�Է¿�:2007/05/11)");
			System.out.println(">>");
			
			try {
				String line = scanner.nextLine();
				Date date = sdFormat.parse(line);

				System.out.println(sdFormat2.format(date));
				
				break;
			} catch(Exception e) {}
		}
	}

}
