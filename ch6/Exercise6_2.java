
public class Exercise6_2 {

	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, false);
		SutdaCard c2 = new SutdaCard();
		
		System.out.println(c1.info());
		System.out.println(c2.info());

	}

}

class SutdaCard{
	int num;
	boolean isKwang;
	
	SutdaCard(){
		this(1, true);
	}
	
	SutdaCard(int n, boolean k){
		num = n;
		isKwang = k;
	}
	
	String info(){
		if(isKwang==true) {
			return num+"K";
		} else {
			return num+"";
		}
		// return num+(isKwang ? "K" : "");
	}
	
	
}
