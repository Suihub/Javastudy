import java.time.*;

public class Exercise10_8 {

	public static void main(String[] args) {
		ZoneId nyZone = ZoneId.of("America/New_York");
		ZonedDateTime seoulTime = ZonedDateTime.now();
		ZonedDateTime nyTime = seoulTime.withZoneSameInstant(nyZone);

		int seoulSec = seoulTime.getOffset().getTotalSeconds();
		int nySec = nyTime.getOffset().getTotalSeconds();
		int diff = (seoulSec-nySec)/(60*60);
		
		System.out.println(seoulTime);
		System.out.println(nyTime);
		System.out.println("sec1="+seoulSec);
		System.out.println("sec2="+nySec);
		System.out.printf("diff=%d hrs%n", diff);
	}

}
