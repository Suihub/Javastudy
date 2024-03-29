import java.util.*;

class BanNoAscending implements Comparator{
	public int compare(Object o1, Object o2) {
		if(!(o1 instanceof Student && o2 instanceof Student)) return -1;
		
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		
		if(s1.ban==s2.ban) return s1.no-s2.no;
		
		return s1.ban-s2.ban;
		
	}
}

public class Exercise11_7 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("���ڹ�",2,1,70,90,70));
		list.add(new Student("���ڹ�",2,2,60,100,80));
		list.add(new Student("ȫ�浿",1,3,100,100,100));
		list.add(new Student("���ü�",1,1,90,70,80));
		list.add(new Student("���ڹ�",1,2,80,80,90));
		
		Collections.sort(list, new BanNoAscending());
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());

	}

}
