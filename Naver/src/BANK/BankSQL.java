package BANK;

import java.sql.*;

public class BankSQL {

	// 1. DB접속
	Connection con = null;
	
	// 2. DB데이터 보내기
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	// 3. DB데이터 받기
	ResultSet rs = null;
	
	
	// [1]DB접속
	public void connect() {
		con = DBC.DBConnect();
	}

	
	// [2]DB접속해제
	public void conClose() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// [3-1]계좌갯수 구하기
	public int acCount() {
		
		int count = 0;
		
		String sql = "SELECT COUNT(*) FROM BANK";
		try {
			// pstmt = con.prepareStatement(sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}


	public void insert(Client ct) {
		String sql = "INSERT INTO BANK VALUES(?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, ct.getAccountNo());
			pstmt.setInt(2, ct.getClientNo());
			pstmt.setString(3, ct.getcName());
			pstmt.setInt(4, ct.getBalance());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println(ct.getcName()+"님 계좌가 생성됐습니다.");
			} else {
				System.out.println("계좌생성에 실패했습니다.");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public void deposit(String accountNo, int balance) {
		String sql = "UPDATE BANK SET BALANCE = BALANCE+? WHERE ACCOUNTNO=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, accountNo);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(balance+"원 입금 성공!");
			} else {
				System.out.println("입금 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public void withdraw(String accountNo, int balance) {
String sql = "UPDATE BANK SET BALANCE = BALANCE-? WHERE ACCOUNTNO=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,balance);
			pstmt.setString(2,accountNo);
			
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				System.out.println(balance+"원 출금이 되었습니다.");
			} else {
				System.out.println("출금 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public int checkBalance(String accountNo) {
		int  result = 0;
		
		String sql = "SELECT BALANCE FROM BANK WHERE ACCOUNTNO = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,accountNo);
			
			rs = pstmt.executeQuery();
				
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public boolean sendCheck(String sAccount) {
		
		boolean result = false;
		String sql = "SELECT * FROM BANK WHERE ACCOUNTNO = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sAccount);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			} else {
				result = false;
				System.out.println("보내시는분의 계좌 번호가 존재하지 않습니다.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}


	public boolean receive(String rAccount) {
		boolean result = false;
		String sql = "SELECT * FROM BANK WHERE ACCOUNTNO = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rAccount);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			} else {
				result = false;
				System.out.println("받으시는분의 계좌 번호가 존재하지 않습니다.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	public void transfer(String sAccount, String rAccount, int sbalance) {
		
		String sql1 = "UPDATE BANK SET BALANCE = BALANCE-? WHERE ACCOUNTNO=?";
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, sbalance);
			pstmt.setString(2,sAccount);
			pstmt.executeUpdate();
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "UPDATE BANK SET BALANCE = BALANCE+? WHERE ACCOUNTNO=?";
		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1,sbalance );
			pstmt.setString(2,rAccount);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("송금 하였습니다.");
			} else {
				System.out.println("송금 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
}
