


public class Exercise6_23 {

	static int Max(int[] arr) {
		if(arr==null || arr.length==0)
			return -999999;
		
		int result = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			if(result<arr[i]) {
				result = arr[i];
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] data = {3, 2, 9, 4, 7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:"+Max(data));
		System.out.println("최대값:"+Max(null));
		System.out.println("최대값:"+Max(new int[] {}));

	}


}
