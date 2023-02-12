import java.time.*;
import static java.time.temporal.TemporalAdjusters.*;

public class Exercise10_7 {

	public static void main(String[] args) {
		LocalDate secondTues = LocalDate.of(2016, 12, 1);
		
		System.out.println(secondTues.with(dayOfWeekInMonth(4, DayOfWeek.TUESDAY)));

	}

}
