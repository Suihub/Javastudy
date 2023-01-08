class Mypoint{
	int x;
	int y;
	
	Mypoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	double getdistance(int x1, int y1) {
		
		return Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
	}
}

public class Exercise6_7 {

	public static void main(String[] args) {
		Mypoint p = new Mypoint(1, 1);
		
		System.out.println(p.getdistance(2, 2));

	}

}
