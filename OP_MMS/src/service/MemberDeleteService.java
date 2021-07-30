package service;

import ui.MemberUI;
import vo.Member;

public class MemberDeleteService {

	public boolean deleteMember(int id) {
		
		boolean ds = false;
		int index = -1;
		
		// 삭제려는 id가 MemberUI.memberArray의 몇번째 index에 들어있는지 찾는 반복문
		for(int i=0; i<MemberUI.memberArray.length; i++) {
			if(MemberUI.memberArray[i].getId()==id) {
				index = i;
			}
		}
		
		// 기존에 있던 배열에서 크기를 1 줄이고, 해당하는 index의 정보를 지우는 작업
		if(index != -1) {
			Member[] tempArr = MemberUI.memberArray;
			MemberUI.memberArray = new Member[MemberUI.memberArray.length-1];
			
			for(int i=0; i<tempArr.length; i++) {
				if(i < index) {
					MemberUI.memberArray[i] = tempArr[i];
				} else if(i>index) {
					MemberUI.memberArray[i-1] = tempArr[i];
				}
			}
			
			ds = true;
		}
		
		return ds;
	}

}
