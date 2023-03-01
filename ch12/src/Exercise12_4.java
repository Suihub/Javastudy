import java.util.*;

class Product{}

public class Exercise12_4 {
	public static <T extends Product> ArrayList<T> merge(
			ArrayList<T> list, ArrayList<T> list2){
		ArrayList<T> newList = new ArrayList<>(list);
		
		newList.addAll(list2);
		
		return newList;
	}
	
	public static void main(String[] args) {
	
	}
}
