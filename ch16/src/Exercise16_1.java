import java.net.*;

public class Exercise16_1 {

	public static void main(String[] args) {
		String hostIp = "192.168.10.100";
		String subnet = "255.255.255.0";
		
		try {
			InetAddress ip = InetAddress.getByName(hostIp);
			InetAddress sub = InetAddress.getByName(subnet);
			
			byte[] ipArr = ip.getAddress();
			byte[] subArr = sub.getAddress();
			
			byte[] network = new byte[4];
			byte[] host = new byte[4];
			
			for(int i=0; i<ipArr.length; i++) {
				network[i] = (byte) (ipArr[i]&subArr[i]);
				host[i] = (byte)(~subArr[i]&ipArr[i]);
			}
			
			InetAddress networkAddress = InetAddress.getByAddress(network);
			InetAddress hostAddress = InetAddress.getByAddress(host);
			
			System.out.println("匙飘况农 林家:"+networkAddress.getHostAddress());
			System.out.println("龋胶飘 林家:"+hostAddress.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
