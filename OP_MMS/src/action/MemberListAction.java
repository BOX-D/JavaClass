package action;

import java.sql.SQLException;
import java.util.Scanner;

import service.MemberListService;
import util.ConsoleUtil;
import vo.Member;

public class MemberListAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		MemberListService mls = new MemberListService();
//		System.out.println("L5 MemberListAction");
//		System.out.println("MemberListService에 있는 "
//				+ "getMemberArray()메소드를 호출해서 Member[] memberArr"
//				+ "에 담는다.");
		Member[] memberArr = mls.getMemberArray();
		
		ConsoleUtil console = new ConsoleUtil();
		
//		if(memberArr.length == 0) {
//			System.out.println("추가된 회원 정보가 없습니다.");
//		} else {
//			
//			for(int i=0; i<memberArr.length; i++) {
//				System.out.println(memberArr[i]);
//			}
//			
//		}
//		System.out.println("L7. ConsoleUtil의 "
//				+ "printMemberList(memberArr)를 호출한다.");
		console.printMemberList(memberArr);
		
	}

}
