import java.util.*;

public class Exercise14_7 {

	public static void main(String[] args) {
		new Random().ints(6, 1, 46)
					.distinct()
					.sorted()
					.forEach(System.out::println);

	}

}
