package service;

import ui.MemberUI;
import vo.Member;

public class MemberRegistService {

	public boolean registMember(Member newMember) throws Exception{
		
		
		boolean registSuccess = true;
				
		// 아이디 중복체크
//		System.out.println("8. MemberRegistService : ");
//		System.out.println("newMember정보를 가지고 아이디 중복체크");
		for(int i=0; i < MemberUI.memberArray.length; i++) {
			if(MemberUI.memberArray[i].getId() == newMember.getId()) {
				registSuccess = false;
				break;
			}
		}
		
		// 아이디가 중복이 아닐 경우 : registSuccess값은 true -> if문 실행
		
		if(registSuccess) {
//			System.out.println("9. MemberRegistService : ");
//			System.out.println("아이디가 중복이 아닐 경우 : ");
						
			Member[] tempArray = MemberUI.memberArray;
			MemberUI.memberArray = new Member[MemberUI.memberArray.length+1];
//			System.out.println("MemberUI.memberArray배열의 크기를 1 늘려주고");
			
			for(int i=0; i<tempArray.length; i++) {
				MemberUI.memberArray[i] = tempArray[i];				
			}
			
//			System.out.println("새로 생긴 배열[index]에 작성한 회원정보를 담는다.");
			MemberUI.memberArray[MemberUI.memberArray.length-1] = newMember;
			
		}
//		System.out.println("10.MemberRegistService : registSuccess의 값은");
//		System.out.println("아이디가 중복이면 false값을 반환, 중복이 아니면 true값 반환");
		return registSuccess;
		
	}
	
}
