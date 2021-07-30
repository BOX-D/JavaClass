package controller;

import java.util.Scanner;

import action.Action;

public class MemberController {
	
	public void processRequest(Scanner sc, Action action) {
		
		/*
		 		
		 		try {
		 		
		 			- 오류가 발생하지 않을 경우 실행
		 		
		 		} catch(예외처리종류 e) {
		 		
		 			- 오류가 발생했을 경우 실행
		 		
		 		} finally {
		 		
		 			- 오류가 발생해도, 발생하지 않아도
		 			    무조건 실행
		 		
		 		}
		 */
		
		try {
			System.out.println("예외처리가 발생하지 않을 경우");
//			System.out.println("L4.MemberController: "
//					+ "MemberUI의 action객체가 null이 아닐경우 이동");
			action.execute(sc);
			
		} catch(Exception e) {
			System.out.println("예외처리가 발생 할 경우");
			System.out.println("e.printStackTrace()를 통해 경로 추적");
			e.printStackTrace();
			// printStackTrace() : 오류발생 경로 및 메세지 출력
		}
		
	}

}
