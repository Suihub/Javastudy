import java.util.stream.*;

public class Exercise14_5 {

	public static void main(String[] args) {
		String[] stuArr = {"aaa", "bb", "c", "dddd"};
		
		int sum = Stream.of(stuArr).mapToInt(String::length).sum();
		
		System.out.println("sum="+sum);

	}

}
