package Regist;

import java.util.Scanner;

public class BOXMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BOXSQL bsql = new BOXSQL();
		BMember bmember = new BMember();
		
		boolean run = true;
		String menu = null;
		
		
		System.out.println("DB Connecting ... ");
		bsql.connect();
		
		do {
			
			System.out.println("┌──┤BOX WEB├──┐");
			System.out.println("│  1.Regist   │");
			System.out.println("│  2.Search   │");
			System.out.println("│  3.Modify   │");
			System.out.println("│  4.Delete   │");
			System.out.println("│  5.Exit     │");
			System.out.println("└─────────────┘");
			System.out.print("Menu >>");
			menu = sc.next();
			
			switch(menu) {
			case "1":		// Regist
				bsql.regist();
				break;
			case "2":		// Search
				bsql.search();
				break;
			case "3":		// Modify
				System.out.print("ID to modify >>");
				String id = sc.next();
				System.out.print("Password for this ID >>");
				String pw = sc.next();
				
				boolean check = bsql.idCheck(id, pw);
				
				if(check) {
					bsql.modifyinfo(id);
					bsql.modify(bmember);
				} else {
					System.out.println("Incorrect ID or password");
				}
				break;
			case "4":		// Delete
				bsql.time();
				break;
			case "5":		// Exit
				run = false;
				bsql.conClose();
				System.out.println("BOXWEB, closing ...");
				break;
			default:
			System.out.println("Error : Invalid input ");
			System.out.println("");
			break;
			}	
		}while(run);

	}

}
