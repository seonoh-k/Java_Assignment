package mms.member.ui;

import java.util.Scanner;

import mms.member.action.Action;
import mms.member.action.MemberAddAction;

public class MemberUI {

	public static void main(String[] args) {

		boolean isStop = false;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
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
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("���α׷� ����");
				isStop = true;
				break;
			default :
				break;
			}
			
			try {
				action.execute(sc);				
			}catch(NullPointerException e) {
				isStop = true;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}while(!isStop);
		
	}

}
