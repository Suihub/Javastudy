class Outer3{
	int value=10;
	
	class Inner2{
		int value=20;
		void method1() {
			int value=30;
			
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer3.this.value);
		}
	}
}

public class Exercise7_27 {

	public static void main(String[] args) {
		Outer3 outer = new Outer3();
		Outer3.Inner2 inner = outer.new Inner2();
		
		inner.method1();

	}

}
