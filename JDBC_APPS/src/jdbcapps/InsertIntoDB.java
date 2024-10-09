package jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoDB {

	public static void main(String[] args) {
		Statement st = null;
		Connection con = null;

		String qry1 = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employees";
			String user = "root";
			String password = "admin";
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();

			qry1 = "insert into emp values(3,'sai',345)";
			System.out.println(st.executeUpdate(qry1));

		}

		catch (SQLException ex) {

			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {

		}
	}

}
