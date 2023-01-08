
public class Exercise6_5 {

	public static void main(String[] args) {
		Student2 s = new Student2("ȫ�浿", 1, 1, 100, 60, 76);
		
		System.out.println(s.info());
	
	}

}

class Student2{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	
	Student2(){}
	
	Student2(String s, int b, int n, int k, int e, int m){
		name = s;
		ban = b;
		no = n;
		kor = k;
		eng = e;
		math = m;
	}
	
	int getTotal(){
		return kor+eng+math;
	}
	
	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5) / 10.0f;
	}
	
	String info() {
		
	return	name+", "+ban+", "+no+", "+kor+", "+eng+", "+math+", "+getTotal()+", "+getAverage();
				
	}
	
}