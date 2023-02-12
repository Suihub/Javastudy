import java.text.*;

public class Exercise10_3 {

	public static void main(String[] args) {
		String data = "123,456,789.5";
		DecimalFormat format = new DecimalFormat("#,###.##");
		DecimalFormat format2 = new DecimalFormat("#");
		DecimalFormat format3 = new DecimalFormat("#,####");
		
		try{
			Number num = format.parse(data);
			double d = num.doubleValue();	
			
			System.out.println("data:"+data);
			System.out.println("�ݿø�:"+format2.format(d));
			System.out.println("�� ����:"+format3.format(d));
		} catch(Exception e) {}
		
	}

}
