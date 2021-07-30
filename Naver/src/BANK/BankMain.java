package BANK;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Client ct = new Client();
		BankSQL bsql = new BankSQL();
		
		boolean run = true;
		int menu = 0;
		
		do {
			System.out.println("===========================================");
			System.out.println("1.DB접속       2.DB접속해제       3.계좌생성       4.입금");
			System.out.println("5.출금           6.잔액조회          7.송금             8.종료");
			System.out.println("===========================================");
			System.out.print("메뉴선택 >> ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				bsql.connect();
				break;
			case 2:
				bsql.conClose();
				break;
			case 3: 
				// 계좌번호 생성
				// 현재 계좌의 갯수 + 1
				int clientNo = bsql.acCount() + 1;
				String accountNo = null;
				
				if(clientNo < 10){
					accountNo = "110-352-33440"+ Integer.toString(clientNo);
				} else if(clientNo < 100) {
					accountNo = "110-352-3344"+ Integer.toString(clientNo);
				}
				
				System.out.print("고객이름 >> ");
				String cName = sc.next();
				
				System.out.print("첫 입금액 >> ");
				int balance = sc.nextInt();
				
//				ct.setAccountNo(accountNo);
//				ct.setClientNo(clientNo);
//				ct.setcName(cName);
//				ct.setBalance(balance);
				
				ct = new Client(accountNo, clientNo, cName, balance);
				System.out.println(accountNo);
				bsql.insert(ct);
				
				break;
			case 4:
				System.out.print("계좌번호 >>");
				accountNo = sc.next();
				
				System.out.print("입금액 >>");
				int dbalance = sc.nextInt();
				
				bsql.deposit(accountNo,dbalance);
				
				break;
			case 5: 
				System.out.print("계좌번호 >>");
				accountNo = sc.next();
				
				System.out.print("출금액 >>");
				int wbalance = sc.nextInt();
				
				balance = bsql.checkBalance(accountNo);
				
				// 현재 잔액이 출금액보다 큰지 확인
				if(balance >= wbalance) {
					bsql.withdraw(accountNo,wbalance);
				} else {
					System.out.println("잔액 부족");
				}
				break;
				
			case 6: 
				// 현재 잔액 조회
				System.out.print("계좌번호 >>");
				accountNo = sc.next();
				
				balance = bsql.checkBalance(accountNo);
				System.out.println("계좌 잔액 : " + balance);
				
			
				break;
			case 7: 
				// 송금시스템
				// (1) 송금인
				System.out.print("보내시는분 계좌 >> ");
				String sAccount = sc.next();
				
				boolean check1  = bsql.sendCheck(sAccount);
				
				// (2) 송금 계좌 잔액
				System.out.print("송금액 >>");
				int sbalance = sc.nextInt();
				balance = bsql.checkBalance(sAccount);
				boolean check2;
				
				if(balance >= sbalance) {
					check2 = true;
				} else {
					check2 = false;
					System.out.println("잔액 부족");
				}
				
				
				// (3) 송금 받는 계좌
				System.out.print("받으시는 분 계좌 >>");
				String rAccount = sc.next();
				boolean check3 = bsql.receive(rAccount);
				
				if(check1 && check2 && check3) {
					bsql.transfer(sAccount,rAccount,sbalance);
				}
				
				break;
			case 8:
				System.out.println("시스템을 종료합니다.");
				run = false;
				break;
			default : 
				System.out.println("잘못 입력했습니다. 다시 입력해주세요!");
				break;
			}			
		} while(run);

	}
}
