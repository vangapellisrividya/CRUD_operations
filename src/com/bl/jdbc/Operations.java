package com.bl.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Operations implements Service {
	@Override
	public void select(Connection con) {
		try (Statement st = con.createStatement()) {
			String Query = "SELECT * FROM employee";
			ResultSet result = st.executeQuery(Query);
			System.out.println(" selected table data is..");
			while (result.next()) {
				System.out.println("| " + result.getInt(1) + " | " + result.getString(2) + " | " + result.getString(3)
						+ " | " + result.getDouble(4) + " | " + result.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Connection con) {
		try (Statement st = con.createStatement()) {
			String Query = "CREATE TABLE emplpyee(id INT NOT NULL,name VARCHAR(20),gender VARCHAR(30), salary DOUBLE, start DATE)";
			st.executeUpdate(Query);
			System.out.println("Table Created......");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Connection con) {
		try (Statement st = con.createStatement()) {
			int update = st.executeUpdate("DELETE FROM employee where id = 3");
			System.out.println(update + " id Deleted...");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Connection con) {
		try (Statement st = con.createStatement()) {
			String Query = "UPDATE employee SET salary = 20000 where id = 1";
			st.executeUpdate(Query);
			System.out.println(" Updated...");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void average(Connection con) {
		try{
			String avgSalary = "select Avg(salary) from employee where gender = 'Female'  group by gender ";
		Statement st = con.createStatement() ;
			ResultSet result = st.executeQuery(avgSalary);
			while (result.next()) {
				Double avgSalary1 = result.getDouble(1);
				System.out.println(" | Average Salary |" +avgSalary1);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void insert(Connection con) {
		try (Statement st = con.createStatement()) {
			int update = st.executeUpdate("insert into employee values(3,'Bill','Male',30000,'2021-06-15')");
			System.out.println(update + " Result shown here..");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
}
