package jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws SQLException {
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
			qry1 = "create table if not exists emp(id int ,name varchar(20),salary double)";
			System.out.println(st.executeUpdate(qry1));
			System.out.println("Table created");
		}

		catch (SQLException ex) {

			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			st.close();
			con.close();
		}
	}

}
