package jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Methods {
	public static void minsalary(Statement st) throws SQLException {
		ResultSet rs = st
				.executeQuery("select * from employee  where salary= (select min(salary) from employee) limit 1");
		System.out.println("Min salary: ");
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double sal = rs.getDouble(3);
			String dig = rs.getString(4);
			System.out.println(id + " " + name + " " + sal + " " + dig);
		}

	}

	public static void maxsalary(Statement st) throws SQLException {
		ResultSet rs = st
				.executeQuery("select * from employee  where salary= (select max(salary) from employee) limit 1");
		System.out.println("Max salary: ");
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double sal = rs.getDouble(3);
			String dig = rs.getString(4);
			System.out.println(id + " " + name + " " + sal + " " + dig);
		}

	}

	public static void main(String[] args) {
		Statement st = null;
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employee";
			String user = "root";
			String password = "admin";
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			minsalary(st);
			maxsalary(st);
		}

		catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {

		}
	}

}
