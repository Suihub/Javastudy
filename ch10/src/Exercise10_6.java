import java.util.*;
import java.text.*;

public class Exercise10_6 {
	public static void main(String[] args) {
		Calendar birthCal = Calendar.getInstance();
		Calendar todayCal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int dayDiff = 0;
		
		birthCal.set(2000, 0, 1);
		
		dayDiff = Math.abs((int)((birthCal.getTimeInMillis()-todayCal.getTimeInMillis())/(24*60*60*1000)));
		
		System.out.println("birth day="+sdf.format(birthCal.getTime()));
		System.out.println("today	 ="+sdf.format(todayCal.getTime()));
		System.out.println(dayDiff+" days");
	}
}
