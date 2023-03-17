import java.util.stream.*;

public class Exercise14_6 {

	public static void main(String[] args) {
		String[] stuArr = {"aaa", "bb", "c", "dddd"};
		
		System.out.println(Stream.of(stuArr).mapToInt(String::length).max().getAsInt());

	}

}
