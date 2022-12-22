
public class Exercise3_7 {

	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = ((int)(5/9f * (fahrenheit-32)*100)+1)/100.0f; // 본인의 답
		      celcius = (int)((5/9f * (fahrenheit-32))*100+0.5)/100f; // 답안의 답          
		
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);

	}

}
