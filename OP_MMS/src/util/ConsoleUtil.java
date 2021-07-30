package util;

import java.util.Scanner;

import vo.Member;
import vo.SearchData;

public class ConsoleUtil {

	// 회원정보를 등록하는 메소드
	public Member getNewMember(Scanner sc) {

		// Member객체 생성
		Member newMember = new Member();

		System.out.println("==== 새 회원 정보 등록 ====");

		System.out.print("회원아이디 >> ");
		int id = sc.nextInt();

		System.out.print("회원이름 >> ");
		String name = sc.next();

		System.out.print("회원연락처 >> ");
		String phone = sc.next();

		System.out.print("회원나이 >> ");
		int age = sc.nextInt();

		System.out.print("회원주소 >> ");
		String addr = sc.next();

		System.out.print("회원이메일 >> ");
		String email = sc.next();

		System.out.print("회원취미 >> ");
		String hobby = sc.next();

		newMember.setId(id);
		newMember.setName(name);
		newMember.setPhone(phone);
		newMember.setAge(age);
		newMember.setAddr(addr);
		newMember.setEmail(email);
		newMember.setHobby(hobby);

		System.out.println(newMember.toString());

//		System.out.println("6.ConsoleUtil: 회원정보를 작성 후 newMember에 담음");
		return newMember;

	}

	// 회원등록이 성공했을 시 메세지
	public void printRegistSuccessMessage(int id) {
		System.out.println(id + "번 회원 등록 성공!");
	}

	// 회원등록이 실패했을 시 메세지
	public void printRegistFailMessage(int id) {
		System.out.println(id + "번 회원 등록 실패!");
	}

	// 회원목록을 출력하는 메소드
	public void printMemberList(Member[] memberArr) {
		// 회원정보 존재유무 파악
//		System.out.println("L8. ConsoleUtil : "
//				+ "회원의 수만큼 반복해서 회원정보를 출력한다.");
		if (memberArr.length == 0) {
			System.out.println("추가된 회원 정보가 없습니다.");
		} else {

			for (int i = 0; i < memberArr.length; i++) {
				System.out.println(memberArr[i]);
			}

		}
	}

	// 회원수정할 id를 찾는 메소드, 삭제할 id 찾는 메소드
	public int findId(String msgkind, Scanner sc) {
		System.out.print(msgkind + "아이디 >> ");
		int id = sc.nextInt();
		return id;
	}

	// 회원정보 수정 메소드
	public Member getUpdateMember(Member oldMember, Scanner sc) {
		// Member객체 생성
		Member member = new Member();

		System.out.println("==== 회원 정보 수정 ====");

		System.out.println("회원아이디 : " + oldMember.getId());

		System.out.println("수정 전 이름 : " + oldMember.getName());
		System.out.print("회원이름 >> ");
		String name = sc.next();

		System.out.println("수정 전 연락처 : " + oldMember.getPhone());
		System.out.print("회원연락처 >> ");
		String phone = sc.next();

		System.out.println("수정 전 나이 : " + oldMember.getAge());
		System.out.print("회원나이 >> ");
		int age = sc.nextInt();

		System.out.println("수정 전 주소 : " + oldMember.getAddr());
		System.out.print("회원주소 >> ");
		String addr = sc.next();

		System.out.println("수정 전 이메일 : " + oldMember.getEmail());
		System.out.print("회원이메일 >> ");
		String email = sc.next();

		System.out.println("수정 전 취미 : " + oldMember.getHobby());
		System.out.print("회원취미 >> ");
		String hobby = sc.next();

		member.setId(oldMember.getId());
		member.setName(name);
		member.setPhone(phone);
		member.setAge(age);
		member.setAddr(addr);
		member.setEmail(email);
		member.setHobby(hobby);

		System.out.println(member.toString());

//		System.out.println("6.ConsoleUtil: 회원정보를 작성 후 newMember에 담음");
		return member;
	}

	// 회원수정이 성공했을 시 메세지
	public void printUpdateSuccessMessage(int id) {
		System.out.println(id + "번 회원 수정 성공!");
	}

	// 회원수정이 실패했을 시 메세지
	public void printUpdateFailMessage(int id) {
		System.out.println(id + "번 회원 수정 실패!");
	}

	// 회원삭제를 성공했을 시 메세지
	public void printDeleteSuccessMessage(int id) {
		System.out.println(id + "번 회원삭제 성공!");
	}

	// 회원삭제를 실패했을 시 메세지
	public void printDeleteFailMessage(int id) {
		System.out.println(id + "번 회원삭제 실패!");
	}

	// 회원검색 메소드
	public SearchData getSearchData(Scanner sc) {
		System.out.println("검색 조건을 선택하세요.");
		System.out.println("아이디");
		System.out.println("이름");
		
		System.out.print("검색 조건 >> ");
		String searchCondition = sc.next();
		String searchValue = null;
		
		if(searchCondition.equals("아이디")) {
			System.out.print("검색 할 아이디 >>");
			searchValue = sc.next();
		} else if(searchCondition.equals("이름")) {
			System.out.print("검색 할 이름 >>");
			searchValue = sc.next();
		}
		
		SearchData search = new SearchData();
		
		search.setSearchCondition(searchCondition);
		search.setSearchValue(searchValue);
						
		return search;
	}

	// 검색 된 결과를 출력하는 메소드
	public void printSearchMember(Member member) {
		if(member == null) {
			System.out.println("검색한 결과가 없습니다.");
		} else {
			System.out.println(member.getId()+"로 검색한 결과");
			System.out.println(member);
		}
		
	}
	
	public void printSearchMember1(Member member) {
		if(member == null) {
			System.out.println("검색한 결과가 없습니다.");
		} else {
			System.out.println(member.getName()+"로 검색한 결과");
			System.out.println(member);
		}
		
	}
	
}
