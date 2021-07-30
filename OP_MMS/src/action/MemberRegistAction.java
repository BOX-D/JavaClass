package action;

import java.util.Scanner;

import service.MemberRegistService;
import util.ConsoleUtil;
import vo.Member;

public class MemberRegistAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
//		System.out.println("5.MemberRegistAction:");
//		System.out.println("MemberController에서 action.execute(sc)호출");
		ConsoleUtil console = new ConsoleUtil();
		Member newMember = console.getNewMember(sc);
//		System.out.println("7.MemberRegistAction:");
//		System.out.println("ConsoleUtil의 getNewMember(sc)에서 받아온 데이터를 newMember에 저장");
		// console.getNewMember(sc) : 입력한 회원정보
		
		
		MemberRegistService mrs = new MemberRegistService();
		boolean registSuccess = mrs.registMember(newMember);
		
		if(registSuccess) {
			// 회원등록성공 메세지(메소드 호출)
//			System.out.println("11.MemberRegistAction : ");
//			System.out.println("반환된 registSuccess값이 참이면 성공 메시지");
			console.printRegistSuccessMessage(newMember.getId());
			
		} else {
			// 회원등록실패 메세지(메소드 호출)
//			System.out.println("11.MemberRegistAction : ");
//			System.out.println("반환된 registSuccess값이 거짓이면 실패 메시지");
			console.printRegistFailMessage(newMember.getId());
		}
		
		
		
	}

}
