
public class Exercise5_6 {

	public static void main(String[] args) {
		int[] coinUnit = {500, 100, 50, 10};
		String[] won = {"500원", "100원", "50원", "10원"};
		
		int coin = 0;
		int money = 2680;
		System.out.println("money="+money);
		
		for(int i=0; i<coinUnit.length; i++) {
			if(money%coinUnit[i]>0 || coinUnit[i]==10) {
				coin = money/coinUnit[i];
				money -= coinUnit[i]*coin;
				System.out.printf("%s: %d%n", won[i], coin);
			} 
			
		}
		
/*		for(int i=0; i<coinUnit.length; i++) {
			System.out.println(coinUnit[i]+"원: "+money/coinUnit[i]);
			money %= coinUnit[i];  
			
		} */

	}

}
