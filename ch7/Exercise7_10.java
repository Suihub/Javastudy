class MyTv2{
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int prechannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	boolean getIsPowerOn(){
		return isPowerOn;
	}
	
	int getChannel() {
		return channel;
	}
	
	int getVolume() {
		return volume;
	}
	
	void setChannel(int channel) {
		if(channel<MIN_CHANNEL || channel >MAX_CHANNEL)
			return;
		
		prechannel = this.channel;
		this.channel = channel;
	}
	
	void setVolume(int volume) {
		if(volume<MIN_VOLUME || volume>MAX_VOLUME)
			return;
		
		this.volume = volume;
	}
	
	void setIsPowerOn() {
		isPowerOn = !isPowerOn;
	}
	
	void gotoPrevChannel() {
		setChannel(prechannel);
	}
}

public class Exercise7_10 {

	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:"+t.getVolume());

	}

}
