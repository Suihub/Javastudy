import java.util.*;

class Student2 implements Comparable{
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	int total; 	
	int schoolRank;
	int classRank; 
	
	Student2(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		total = kor+eng+math;
	}
	
	int getTotal() {
		return total;
	}
	
	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}
	
	public String toString() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+
	getAverage()+","+schoolRank+","+classRank;
	}

	public int compareTo(Object o) {
		if(o instanceof Student2) {
			Student2 s = (Student2)o;
		
			return s.total - total;
		} else {
			return -1;
		}

	}
	
}

class ClassTotalComparator implements Comparator{
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student2 && o2 instanceof Student2) {
			Student2 s1 = (Student2)o1;
			Student2 s2 = (Student2)o2;
			
			return ((s1.ban*100) - (s2.ban*100)) + (s2.total - s1.total);
			
		}else {
			return -1;
		}
	}
}

public class Exercise11_8 {	
	public static void calculateClassRank(List list) {
		Collections.sort(list, new ClassTotalComparator());
		
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
		for(int i=0; i<length; i++) {
			Student2 s = (Student2)list.get(i);
			
			if(prevBan != s.ban) {
				prevRank = -1;
				prevTotal = -1;
			} else if(prevTotal == s.total) {
				s.classRank = prevTotal;
				continue;
			}
			
			s.classRank = i%3+1;
			
			prevBan = s.ban;
			prevRank = s.classRank;
			prevTotal = s.total;
		}
	}
	
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); 
		
		int prevRank = -1; 	
		int prevTotal = -1; 
		int length = list.size();
		
		for(int i=0; i<length; i++) {
			Student2 s = (Student2)list.get(i);
			
			if(s.total==prevTotal) {
				s.schoolRank = prevRank;
				continue;
			}
			
			s.schoolRank = i+1;
			
			prevRank = s.schoolRank;
			prevTotal = s.total;
		}
	}
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student2("ÀÌÀÚ¹Ù",2,1,70,90,70));
		list.add(new Student2("¾ÈÀÚ¹Ù",2,2,60,100,80));
		list.add(new Student2("È«±æµ¿",1,3,100,100,100));
		list.add(new Student2("³²±Ã¼º",1,1,90,70,80));
		list.add(new Student2("±èÀÚ¹Ù",1,2,80,80,90));

		calculateSchoolRank(list);
		calculateClassRank(list);
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	}

}
