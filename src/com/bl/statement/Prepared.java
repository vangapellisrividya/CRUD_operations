package com.bl.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Prepared implements Interface {
	private static Scanner sc = new Scanner(System.in);

	@Override
	public void insert(Connection con) {

		try {
			Statement st = con.createStatement();
			System.out.println("Enter the employee id");
			int empid = sc.nextInt();
			System.out.println("Enter the employee name");
			String empname = sc.next();
			System.out.println("Enter the employee salary");
			double empsalary = sc.nextDouble();

			st.executeUpdate("insert into employee value('" + empid + "','" + empname + "','" + empsalary + "')");

			System.out.println("Values inserted successfully..");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Connection con) {

	}

	@Override
	public void select(Connection con) {

	}

}