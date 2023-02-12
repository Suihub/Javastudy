import java.text.*;
import java.util.*;

public class Exercise10_1 {

	public static void main(String[] args) {
		Calendar secondSun = Calendar.getInstance();
		SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd�� F��° E�����Դϴ�.");
		
		for(int i=0; i<=Calendar.DECEMBER; i++) {
			secondSun.set(2010, i, 1);
			secondSun.set(Calendar.DAY_OF_WEEK, 1);
			secondSun.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2);
			
			Date tmp = secondSun.getTime();
			System.out.println(pattern.format(tmp));
		}
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
	}

}
