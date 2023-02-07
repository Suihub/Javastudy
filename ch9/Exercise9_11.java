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
					throw new Exception("시작 단과 끝 단, 두 개의 정수를 입력해주세요.");

				table = Integer.parseInt(arg[0]);
				table2 = Integer.parseInt(arg[1]);				
			
				if(table<2 || table>9 || table2<2 || table2>9) 
					throw new Exception("단의 범위는 2와 9 사이의 값이어야 합니다.");

			} catch(NumberFormatException NE) {
				System.out.println("숫자만 입력할 수 있습니다. 다시 입력해주세요.");
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
