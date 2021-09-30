package com.bl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

class Main {
	static Connection con = null;

	public static void main(String[] args) {
		Service service = new Operations();
		Scanner scanner = new Scanner(System.in);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "Vidya@0699");
			System.out.println(" connection is successful ");
			int choice = 0;
			String choose = "yes";
			char select = choose.charAt(0);
			

			do {
				System.out.println(" Enter the option ");
				System.out.println(
						"1. SelectEmployeeData\n2. CreateTable\n3. Delete\n4. Update\n5. Average\n6. Insert\n7. Exit ");

				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					service.select(con);
					break;
				case 2:
					service.create(con);
					break;
				case 3:
					service.delete(con);
					break;
				case 4:
					service.update(con);
					break;
				case 5:
					service.average(con);
					break;
				case 6:
					service.insert(con);
					break;
				case 7:
					System.exit(choice);
					break;

				}
			}

			while (select == 'y' || select == 'Y');
			System.out.println(select);
			System.out.println(" Thank you for the participation ");

		} catch (Exception e)

		{
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		scanner.close();
	}

}
