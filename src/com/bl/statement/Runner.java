package com.bl.statement;

import java.sql.DriverManager;
import java.sql.Connection;

public class Runner {
	static Connection con = null;

	public static void main(String[] args) {
		Interface service = new Prepared();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeepayroll", "root", "Vidya@0699");
			System.out.println(" connection is successful ");
 
			service.insert(con);
			con.close();

		} catch (Exception e)

		{
			e.printStackTrace();
		}

	}

}
