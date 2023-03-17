import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Exercise14_4 {

	public static void main(String[] args) {
		List<Integer> dice = new ArrayList<>();
		
		for(int i=1; i<=6; i++)
			dice.add(i);
	
		Predicate<Integer> p = i -> i==6;
		BinaryOperator<Integer> bo = (i, i2) -> i+i2;
		
		printSumSix(p, bo, dice, dice);
		
		dice.stream().flatMap(i -> Stream.of(1, 2, 3, 4, 5, 6).map(i2 -> new int[] {i, i2}))
					 .filter(i -> i[0]+i[1] ==6)
					 .forEach(i -> System.out.println(Arrays.toString(i)));
		
	}

	static <T> void printSumSix(Predicate<T> p, BinaryOperator<T> bo, List<T> dice1, List<T> dice2) {
		for(T num : dice1) {
			for(T num2 : dice2) {
				if(p.test(bo.apply(num, num2)))
					System.out.println("["+num+", "+num2+"]");
			}
		}
	}
}


