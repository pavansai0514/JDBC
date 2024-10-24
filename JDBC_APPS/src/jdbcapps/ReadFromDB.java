package jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadFromDB {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Statement st = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Enter Database Name:");
			String dbname = sc.next();
			String url = "jdbc:mysql://localhost:3306/" + dbname;
			String user = "root";
			String password = "admin";
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			System.out.println("Enter table Name:");
			String tablename = sc.next();
			String qry1 = "select * from " + tablename;
			rs = st.executeQuery(qry1);

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
			rs.close();
			st.close();
			con.close();
		}
	}

}
