
public class Exercise9_10 {
	public static String format(String str, int length, int alignment) {	
		int distance = length - str.length();
		
		if(distance<0)
			return str.substring(0, length);
		
		char[] sorted = new char[length];
		
		switch(alignment) {
			case 0:
				System.arraycopy(str.toCharArray(), 0, sorted, 0, str.length());
				break;
			case 1:
				System.arraycopy(str.toCharArray(), 0, sorted, distance/2, str.length());
				break;
			case 2:
				System.arraycopy(str.toCharArray(), 0, sorted, distance, str.length());
				break;
			default:
				return "다시 입력해주세요";
		}
		
		return new String(sorted);
		
	}
	public static void main(String[] args) {
		String str = "가나다";
		
		System.out.println(format(str, 7, 0));
		System.out.println(format(str, 7, 1));
		System.out.println(format(str, 7, 2));

	}

}
