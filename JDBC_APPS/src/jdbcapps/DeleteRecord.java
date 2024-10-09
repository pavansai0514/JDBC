package jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {

	public static void main(String[] args) {
		Statement st = null;
		Connection con = null;

		String qry1 = "";
		String qry2 = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employees";
			String user = "root";
			String password = "admin";
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();

			qry1 = "delete from emp where id=1";
			System.out.println(st.executeUpdate(qry1));
			System.out.println("Table Records");
			qry2 = "select * from emp";

			ResultSet rs = st.executeQuery(qry2);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double sal = rs.getDouble(3);
				System.out.println(id + " " + name + " " + sal);
			}

		}

		catch (SQLException ex) {

			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {

		}
	}

}
