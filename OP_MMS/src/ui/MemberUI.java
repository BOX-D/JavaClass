package ui;

import java.util.Scanner;

import action.Action;
import action.MemberDeleteAction;
import action.MemberListAction;
import action.MemberRegistAction;
import action.MemberSearchAction;
import action.MemberUpdateAction;
import controller.MemberController;
import util.ConsoleUtil;
import vo.Member;

public class MemberUI {

	// 1. 필드(DB부분)
	public static Member[] memberArray = new Member[0];

	// 2. 메소드
	public static void main(String[] args) {

		MemberController controller = new MemberController();
		ConsoleUtil console = new ConsoleUtil();
		boolean run = true;

		Scanner sc = new Scanner(System.in);
		Action action = null;

		int menu = 0;

		do {
			System.out.println("====================================");
			System.out.println(" 1.회원등록          2.회원목록       3.회원수정     ");
			System.out.println("------------------------------------");
			System.out.println(" 4.회원삭제          5.회원검색       6.시스템종료  ");
			System.out.println("====================================");

			System.out.print("선택 >> ");
			menu = sc.nextInt();

			switch (menu) {

			case 1: // 회원등록
//				System.out.println("1.MemberUI: 회원등록 선택");
//				System.out.println("2.MemberUI: action객체에 "
//						+ "new MemberRegistAction() 담김");
				action = new MemberRegistAction();

				break;
			case 2: // 회원목록
//				System.out.println("L1.MemberUI: 회원목록 선택");
//				System.out.println("L2.MemberUI: action객체에 "
//						+ "new MemberListAction() 담김");
				action = new MemberListAction();
				break;
			case 3: // 회원수정
				action = new MemberUpdateAction();
				break;
			case 4: // 회원삭제
				action = new MemberDeleteAction();
				break;
			case 5: // 회원검색
				action = new MemberSearchAction();
				break;
			case 6: // 시스템종료
				System.out.println("시스템을 종료합니다!");
				run = false;
				action = null;
				break;
			default: // 그외
				System.out.println("잘못 입력했습니다. 다시 입력해주세요!");
				action = null;
				break;
			}

			if (action != null) {
//					System.out.println("L3.MemberUI: action객체가 null이 아닐 경우");
				controller.processRequest(sc, action);
			}

		} while (run);

	}

}
