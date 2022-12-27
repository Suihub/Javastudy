
public class Exercise4_12 {

	public static void main(String[] args) {
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				
				if(j==4) {
					break;
				}
				
				System.out.println(i+"*"+j+"="+i*j);
				
				
			} //for2 end
			
			System.out.println();
			
		} // for1 end

	}

}
