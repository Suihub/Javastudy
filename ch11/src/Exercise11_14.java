import java.io.*;
import java.util.*;

public class Exercise11_14 {
	static ArrayList record = new ArrayList();
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			switch(displayMenu()) {
			case 1 :
				inputRecord();
				break;
			case 2 :
				displayRecord();
				break;
			case 3 :
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
		}

	}

	static int displayMenu() {
		System.out.println("********************************************");
		System.out.println("*              ���� ���� ���α׷�                           *");
		System.out.println("********************************************");
		System.out.println();
		System.out.println("1. �л����� �Է��ϱ�");
		System.out.println();
		System.out.println("2. �л����� ����");
		System.out.println();
		System.out.println("3. ���α׷� ����");
		System.out.println();
		System.out.println("���ϴ� �޴��� �����ϼ���.(1~3) : ");
		
		int menu = 0;
		
		while(true) {
			try {
				
				int input = Integer.parseInt(s.nextLine().trim());
			
				if(1<=input && input<=3) {
					menu = input;
					break;
				} else {
					throw new Exception();
				}
			} catch(Exception e) {
				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				System.out.println("���ϴ� �޴��� �����ϼ���.(1~3) : ");
			}
		}
		
		return menu;
	}
	
	
	static void inputRecord() {
		System.out.println("1. �л����� �Է��ϱ�");
		System.out.println("�̸�,��,��ȣ,�����,�����,���м����� ������ ������� �Է��ϼ���.");
		System.out.println("�Է��� ��ġ���� q�� �Է��ϼ���. ���� ȭ������ ���ư��ϴ�.");
		
		while(true) {
			System.out.print(">>");
			
			String line = s.nextLine().trim();
				
			if(line.equalsIgnoreCase("q")) return;	

			try {		

				Scanner s2 = new Scanner(line).useDelimiter(",");
							
				Student2 sd = new Student2(s2.next(), s2.nextInt(), s2.nextInt(), s2.nextInt(),
						s2.nextInt(), s2.nextInt());
				
				record.add(sd);
				System.out.println("�� �ԷµǾ����ϴ�. �Է��� ��ġ���� q�� �����ϼ���.");
			} catch(Exception e) {
				System.out.println("�Է¿����Դϴ�. �̸�,��,��ȣ,�����,�����,���м����� ������ ������� �Է��ϼ���.");
			}
		}
	}
	
	static void displayRecord() {
		int koreanTotal = 0;
		int englishTotal = 0;
		int mathTotal = 0;
		int total = 0;
		
		int length = record.size();
		
		if(length > 0) {
			System.out.println();
			System.out.println("�̸� �� ��ȣ ���� ���� ���� ���� ��� ������� �ݵ��");
			
			System.out.println("=================================================");
			
			for(int i=0; i<length; i++) {
				Student2 student = (Student2)record.get(i);
				System.out.println(student);
				koreanTotal += student.kor;
				mathTotal += student.math;
				englishTotal += student.eng;
				total += student.total;
			}
			
			
			System.out.println("=================================================");			
			System.out.println("����: "+koreanTotal+" "+englishTotal
					+" "+mathTotal+" "+total);
			System.out.println();
		} else {
			System.out.println("=================================================");
			System.out.println(" �����Ͱ� �����ϴ�. ");
			System.out.println("=================================================");
		}
	}
}
