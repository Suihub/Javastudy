
public class Excercise8_9 {

	public static void main(String[] args) throws Exception {
		
		throw new UnsupportedFuctionException("�������� �ʴ� ����Դϴ�.", 100);

	}

}

class UnsupportedFuctionException extends RuntimeException{
	final private int ERR_CODE;
	
	UnsupportedFuctionException(String msg){
		this(msg, 100);
	}
	
	UnsupportedFuctionException(String msg, int err){
		super(msg);
		ERR_CODE = err;
	}
	
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	public String getMessage() {
		return "["+getErrorCode()+"]"+super.getMessage();
	}
}
