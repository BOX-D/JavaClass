package action;

import java.util.Scanner;

import service.MemberUpdateService;
import util.ConsoleUtil;
import vo.Member;

public class MemberUpdateAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil console = new ConsoleUtil();
		int id = console.findId("수정할 ", sc);
		
		MemberUpdateService mus = new MemberUpdateService();
		Member oldMember = mus.getOldMember(id);
		Member updateMember = console.getUpdateMember(oldMember,sc);
		
		boolean us = mus.updateMember(updateMember);
		
		if(us) {
			// System.out.println("회원정보 수정 성공!");
			console.printUpdateSuccessMessage(updateMember.getId());
		} else {
			// System.out.println("회원정보 수정 실패!");
			console.printUpdateFailMessage(updateMember.getId());
		}

	}
}
