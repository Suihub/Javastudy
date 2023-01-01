
public class Exercise5_11 {

	public static void main(String[] args) {
		int[][] score = {
				{100, 100, 100},
				{20, 20, 20},
				{30, 30, 30},
				{40, 40, 40},
				{50, 50, 50}
		};

		int[][] result = new int[score.length+1][score[0].length+1];
		
		int num1=0, num2=0, num3=0;
		
		for(int i=0; i<score.length; i++) {
			int sum = 0;
			
			result[5][0] = (num1 += score[i][0]);
			result[5][1] = (num2 += score[i][1]);
			result[5][2] = (num3 += score[i][2]);
			result[5][3] = (num1 + num2 + num3); 
			
			for(int j=0; j<score[i].length; j++) {
				result[i][j]=score[i][j];
				result[i][3]=(sum += result[i][j]);
			}
			
		}// for end
			
		
/*		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				result[i][j]=score[i][j];
				result[score.length][j]+=result[i][j];
				result[i][score[0].length]+=result[i][j];
				result[score.length][score[0].length]+=result[i][j];
			}
		}// for end
			*/
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				System.out.printf("%4d", result[i][j]);
			}
			System.out.println();
		}// for end 2
		
	}

}
