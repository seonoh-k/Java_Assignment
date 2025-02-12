package mms.member.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import mms.member.action.Action;
import mms.member.action.MemberAddAction;
import mms.member.action.MemberDeleteAction;
import mms.member.action.MemberEditAction;
import mms.member.action.MemberPrintAction;

public class MemberUI {

	public static void main(String[] args) {

		boolean isStop = false;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				System.out.println("=====ȸ������ ���α׷�=====");
				System.out.println("1.ȸ�����");
				System.out.println("2.ȸ����Ϻ���");
				System.out.println("3.ȸ����������");
				System.out.println("4.ȸ����������");
				System.out.println("5.���α׷� ����");
				System.out.print("�޴� ��ȣ : ");
				
				int menu = sc.nextInt();
				Action action = null;
				
				switch(menu) {
				case 1:
					action = new MemberAddAction();
					break;
				case 2:
					action = new MemberPrintAction();
					break;
				case 3:
					action = new MemberEditAction();
					break;
				case 4:
					action = new MemberDeleteAction();
					break;
				case 5:
					System.out.println("���α׷� ����");
					isStop = true;
					break;
				default :
					break;
				}
				
				action.execute(sc);								
			}catch(InputMismatchException e) { 
				// ���Է� ����
				System.out.println("�߸��� �Է��Դϴ�");
				System.out.println("�ٽ� �Է����ּ���");
				sc.next();
			}catch(NullPointerException e) {
				isStop = true;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}while(!isStop);
		
	}

}
