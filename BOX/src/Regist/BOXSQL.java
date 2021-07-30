package Regist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BOXSQL {
	// 쿼리문을 모아 놓은 클래스 BOXSQL
	
		// DB 접속을 위한 변수 선언
		Connection con = null;
		
		// DB로 쿼리문 전송을 위한 변수 선언
		Statement stmt = null;
		PreparedStatement pstmt = null;
		// PreparedStatement : ? 를 문자로 인식!
		
		// 조회(SELECT)의 결과를 저장하기 위한 변수 선언
		ResultSet rs = null;
	
		// 접속 메소드
		public void connect() {
			con = DBC.DBConnect();
		}
		
		// 접속해제 메소드
		public void conClose() {
			try {
				con.close();
				System.out.println("DB접속해제!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 회원 가입 메소드
		public void regist() {
			Scanner sc = new Scanner(System.in);
			BMember bmember = new BMember();
			boolean password = true;
			String b_pw = null;

			System.out.println("회원정보를 입력해주세요.");
			System.out.print("ID >> ");
			String b_id = sc.next();
			do {
			System.out.print("Password >> ");
			String b_pw1 = sc.next();
			
			System.out.println("Password Confirm >>");
			String b_pw2 = sc.next();
			
			if(b_pw1.equals(b_pw2)) {
				password = false;
				b_pw = b_pw1;
				System.out.println("Password was correct");
			} else {
				System.out.println("Please,re-enter password");
			}
			}while(password);
			System.out.print("Fitst Name >> ");
			String first_name = sc.next();
			
			System.out.print("Last Name >> ");
			String last_name = sc.next();
			
			String b_name = first_name +" " +last_name;
			
			System.out.print("Email >> ");
			String b_email = sc.next();
			
			System.out.print("Phone Numeber >> ");
			String b_phone = sc.next();
			
			System.out.print("Address >> ");
			String b_addr = sc.next();
			
			bmember.setB_id(b_id);
			bmember.setB_pw(b_pw);
			bmember.setB_name(b_name);
			bmember.setB_email(b_email);
			bmember.setB_phone(b_phone);
			bmember.setB_addr(b_addr);
			
			String sql = "INSERT INTO BOXWEB VALUES(?,?,?,?,?,?)";
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, bmember.getB_id());
				pstmt.setString(2, bmember.getB_pw());
				pstmt.setString(3, bmember.getB_name());
				pstmt.setString(4, bmember.getB_phone());
				pstmt.setString(5, bmember.getB_email());
				pstmt.setString(6, bmember.getB_addr());
				
				int result = pstmt.executeUpdate();
				
				if(result>0) {
					System.out.println("회원가입 성공!");
				} else {
					System.out.println("회원가입 실패!");
				}
				
				
			} catch (SQLException e) {
				System.out.println("SQLException 발생!");
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		} //regist


		
		// 회원 조회 메소드
		public void search() {
			Scanner sc = new Scanner(System.in);
			String menu;
			System.out.println("┌──┤BOX WEB├──┐");
			System.out.println("│  Search by  │");
			System.out.println("│  1.ID       │");
			System.out.println("│  2.Name     │");
			System.out.println("│             │");
			System.out.println("│  3.back     │");
			System.out.println("└─────────────┘");
			System.out.print("menu >>");
			menu = sc.next();
			switch(menu){
			case "1" :
				System.out.print("Search by ID >>");
				String id = sc.next();
				
				String sql = "SELECT * FROM BOXWEB WHERE B_ID=?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,id);
					rs = pstmt.executeQuery();
					while(rs.next()) {
					System.out.println("ID : " + rs.getString("B_ID"));
					System.out.println("Name : " + rs.getString("B_NAME"));
					System.out.println("Phone_Number : " + rs.getString("B_PHONE"));
					System.out.println("Email : " + rs.getString("B_EMAIL"));
					System.out.println("Address : " + rs.getString("B_ADDR"));
					System.out.println();
					}//while
				} catch (SQLException e) {
					e.printStackTrace();
					
				} finally {
					try {
						pstmt.close();
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				break;
			case "2" :
				System.out.print("Search by Name >>");
				String name = sc.next();
				
				String sql1 = "SELECT * FROM BOXWEB WHERE B_NAME=?";
				try {
					pstmt = con.prepareStatement(sql1);
					pstmt.setString(1, name);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						System.out.println("ID : " + rs.getString("B_ID"));
						System.out.println("Name : " + rs.getString("B_NAME"));
						System.out.println("Phone_Number : " + rs.getString("B_PHONE"));
						System.out.println("Email : " + rs.getString("B_EMAIL"));
						System.out.println("Address : " + rs.getString("B_ADDR"));
						System.out.println();
						}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "3" :
				break;
			default :
				System.out.println("Error : Invalid input");
				break;
			}
			
			
		} //search
		
		public boolean idCheck(String id, String pw) {
			
			// (1) 메소드 데이터타입과 같은 변수 만들고 초기값 선언하기
			boolean checkResult = false;
			
			String sql = "SELECT B_ID FROM BOXWEB WHERE B_ID = ? AND B_PW = ?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,id);
				pstmt.setString(2,pw);
				
				if(rs.next()) { // 결과 값이 존재 O
					checkResult = true;
				} else {		// 결과 값이 존재 X
					checkResult = false;
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			// (2) 만들어준 변수를 return하기
			
			return checkResult;
		} //idCheck 

		public void modifyinfo(String id) {
			BMember bmember = new BMember();
			Scanner sc = new Scanner(System.in);
			boolean password = true;
			String b_pw = null;
			
			System.out.println(id+"님의 회원정보를 수정해주세요.");
			
			do {
			System.out.print("Password >> ");
			String b_pw1 = sc.next();
			
			System.out.println("Password Confirm >>");
			String b_pw2 = sc.next();
	
			if(b_pw1.equals(b_pw2)) {
				password = false;
				b_pw = b_pw1;
				System.out.println("Password was correct");
			} else {
				System.out.println("Please,re-enter password");
			}
			}while(password);
			
			System.out.print("Fitst Name >> ");
			String first_name = sc.next();
			
			System.out.print("Last Name >> ");
			String last_name = sc.next();
			
			String b_name = first_name +" " +last_name;
			
			System.out.print("Phone_Number >> ");
			String b_phone = sc.next();
					
			System.out.print("Email >> ");
			String b_email = sc.next();
			
			System.out.print("Address >> ");
			String b_addr = sc.next();
			
			
			bmember.setB_pw(b_pw);
			bmember.setB_name(b_name);
			bmember.setB_email(b_email);
			bmember.setB_phone(b_phone);
			bmember.setB_addr(b_addr);
			
			
		}//modifyinfo

		public void modify(BMember bmember) {
			String sql = "UPDATE BOXWEB SET B_PW=?,B_NAME=?,B_PHONE=?,B_EMAIL=?,B_ADDR=? WHERE B_ID=?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,bmember.getB_pw());
				pstmt.setString(2,bmember.getB_name());
				pstmt.setString(3,bmember.getB_phone());
				pstmt.setString(4,bmember.getB_email());
				pstmt.setString(5,bmember.getB_addr());
				pstmt.setString(6,bmember.getB_id());
				
				int result = pstmt.executeUpdate();
				if(result>0) {
					System.out.println("정보 수정 완료");
				} else {
					System.out.println("정보 수정 실패");
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		} // modify

		public void time() {
			
				String sql1 = "SELECT TO_CHAR(SYSDATE,'YYMMDDHH24') FROM DUAL";
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql1);
					if(rs.next()) {
						int date1 = Integer.parseInt(rs.getString(1));
						System.out.println(date1);
						
						String sql2 =  "SELECT S_CODE,TO_CHAR(S_DATE,'YYMMDDHH24') FROM SELLER";
						stmt = con.createStatement();
						rs = stmt.executeQuery(sql2);
						while(rs.next()) {
							int date2 = Integer.parseInt(rs.getString(2));
							if(date1>date2) {
								
								
								
								System.out.println("갱신");
								
								
								
							}
						}
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			
			
			
			
		}
			
			
		




