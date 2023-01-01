
public class Exercise5_9 {

	public static void main(String[] args) {
		char[][] star = {
				{'*', '*', ' ', ' ', ' '},
				{'*', '*', ' ', ' ', ' '},
				{'*', '*', '*', '*', '*'},
				{'*', '*', '*', '*', '*'}
		};
		
		char[][] result = new char[star[0].length][star.length];
		// 5За 4ї­
		
		for(int i=0; i<star.length; i++) {
			for(int j=0; j<star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}// for end

		System.out.println();
		
	    for(int i=0; i<star.length; i++) {
			for(int j=0; j<star[i].length; j++) {
				int y = star.length-1-i;
				result[j][y]=star[i][j];
				
			}
		}// for end 2 
		
		
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}// for end 3
	}

}
