import java.util.*;
import java.util.stream.*;

public class Exercise14_9 {

	public static void main(String[] args) {
		Student[] stuArr = {
				new Student("���ڹ�", true, 1, 1, 300),
				new Student("������", false, 1, 1, 250),
				new Student("���ڹ�", true, 1, 1, 200),
				new Student("������", false, 1, 2, 150),
				new Student("���ڹ�", true, 1, 2, 100),
				new Student("������", false, 1, 2, 50),
				new Student("Ȳ����", false, 1, 3, 100),
				new Student("������", false, 1, 3, 150),
				new Student("���ڹ�", true, 1, 3, 200),
				
				new Student("���ڹ�", true, 2, 1, 300),
				new Student("������", false, 2, 1, 250),
				new Student("���ڹ�", true, 2, 1, 200),
				new Student("������", false, 2, 2, 150),
				new Student("���ڹ�", true, 2, 2, 100),
				new Student("������", false, 2, 2, 50),
				new Student("Ȳ����", false, 2, 3, 100),
				new Student("������", false, 2, 3, 150),
				new Student("���ڹ�", true, 2, 3, 200)	
		};
		
		Map<Integer, Map<Integer, Long>> totalScoreByHakAndBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student::getHak,
						 Collectors.groupingBy(Student::getBan, 
								 Collectors.summingLong(Student::getScore))));
		
		for(Object e : totalScoreByHakAndBan.entrySet()) {
			System.out.println(e);
		}
	}

}
