import javax.swing.JOptionPane;

public class Exercise13_9 {

	public static void main(String[] args) {
		Exercise13_9_1 th1 = new Exercise13_9_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� "+input+"�Դϴ�.");
		th1.interrupt();

	}

}

class Exercise13_9_1 extends Thread{
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				interrupt();
			}
		}
		
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	}
}