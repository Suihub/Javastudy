
public class Exercise6_20 {
	static int[] Shuffle(int[] arr) {
		if(arr==null || arr.length==0)
			return arr;
		
		
		for(int i=0; i<arr.length; i++) {
			int j = (int)(Math.random()*arr.length);
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = Shuffle(original);
		System.out.println(java.util.Arrays.toString(result));

	}

}
