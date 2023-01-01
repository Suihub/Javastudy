import java.util.Scanner;

public class Exercise5_12 {

	public static void main(String[] args) {
		String[][] words = {
				{"chair", "의자"},
				{"computer", "컴퓨터"},
				{"integer", "정수"}
		};
		
		int count = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<words.length; i++) {
			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);
			
			String input = scanner.nextLine();
			
			if(input.equals(words[i][1])) {
				System.out.println("정답입니다.");
				System.out.println();
				count++;
			} else {
				System.out.printf("틀렸습니다. 정답은 %s입니다. %n%n", words[i][1]);
			}
			
			
			
		}// for end

		System.out.printf("전체 %d문제 중 %d문제 맞추셨습니다.", words.length, count);


	}

}
