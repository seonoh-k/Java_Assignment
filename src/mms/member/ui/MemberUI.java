package mms.member.ui;

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
			
			System.out.println("=====회원관리 프로그램=====");
			System.out.println("1.회원등록");
			System.out.println("2.회원목록보기");
			System.out.println("3.회원정보수정");
			System.out.println("4.회원정보삭제");
			System.out.println("5.프로그램 종료");
			System.out.print("메뉴 번호 : ");
			
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
				System.out.println("프로그램 종료");
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
