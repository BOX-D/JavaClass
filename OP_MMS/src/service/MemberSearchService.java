package service;

import ui.MemberUI;
import vo.Member;

public class MemberSearchService {

	public Member searchMemberById(String searchValue) {
		
		Member member = null;
		
		int id = Integer.parseInt(searchValue);
		// Integer.parseInt("100"); ==> int 100
		// String 타입을 int 타입으로 바꾸는 방법
		
		
		for(int i=0; i<MemberUI.memberArray.length; i++) {
			if(MemberUI.memberArray[i].getId()==id) {
				member = MemberUI.memberArray[i];
				break;
			}
		}
		
		return member;
		
	}

	public Member searchMemberByName(String searchValue) {
		
		Member member = null;
		
		
		for(int i=0; i<MemberUI.memberArray.length; i++) {
			if(MemberUI.memberArray[i].getName().equals(searchValue)) {
				member = MemberUI.memberArray[i];
				break;
			}
		}
		
		return member;
	}

}
