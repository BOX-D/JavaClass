package action;

import java.util.Scanner;

import service.MemberDeleteService;
import util.ConsoleUtil;

public class MemberDeleteAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil console = new ConsoleUtil();
		int id = console.findId("삭제할 ", sc);
		
		MemberDeleteService mds = new MemberDeleteService();
		
		boolean ds = mds.deleteMember(id);
		
		if(ds) {
			// System.out.println(id + "번 회원삭제 성공!");
			console.printDeleteSuccessMessage(id);
		} else {
			// System.out.println(id + "번 회원삭제 실패!");
			console.printDeleteFailMessage(id);
		}

	}

}
