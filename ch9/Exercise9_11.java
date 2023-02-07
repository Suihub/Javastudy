import java.util.*;

public class Exercise9_11 {

	public static void main(String[] args) {
		int table = 0;
		int table2 = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			String input = sc.nextLine();
			
			String[] arg = input.split(" +");
			
			try {
				if(arg.length < 2)
					throw new Exception("���� �ܰ� �� ��, �� ���� ������ �Է����ּ���.");

				table = Integer.parseInt(arg[0]);
				table2 = Integer.parseInt(arg[1]);				
			
				if(table<2 || table>9 || table2<2 || table2>9) 
					throw new Exception("���� ������ 2�� 9 ������ ���̾�� �մϴ�.");

			} catch(NumberFormatException NE) {
				System.out.println("���ڸ� �Է��� �� �ֽ��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			} catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("USAGE: GugudanTest 3 5");
				continue;
			}
			
			if(table > table2) {
				int tmp = 0;
				tmp = table;
				table = table2;
				table2 = tmp;
			}
			
			for(int i=table; i<=table2; i++) {
				for(int j=1; j<=9; j++)
					System.out.printf("%d*%d=%d%n", i, j, i*j);
				System.out.println();
			}
			
			break;

			
		}

	}

}
