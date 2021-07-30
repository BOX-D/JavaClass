package service;

import ui.MemberUI;
import vo.Member;

public class MemberListService {
	
	public Member[] getMemberArray() {
//		System.out.println("L6 MemberListService : ");
//		System.out.println("getMemberArray()는 "
//				+ "MemberUI.memberArray값을 반환한다.");
		return MemberUI.memberArray;
		
	}

}
