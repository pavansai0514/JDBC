package jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.mysql.cj.jdbc.CallableStatement;

public class Add {

	public static void main(String[] args) throws SQLException {

		Statement st = null;
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employee";
			String user = "root";
			String password = "admin";
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();

			CallableStatement cs = (CallableStatement) con.prepareCall("{call asmd(?,?,?,?,?,?)}");
			Scanner sc = new Scanner(System.in);
			cs.setInt(1, sc.nextInt());
			cs.setInt(2, sc.nextInt());

			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			cs.registerOutParameter(4, java.sql.Types.INTEGER);
			cs.registerOutParameter(5, java.sql.Types.INTEGER);
			cs.registerOutParameter(6, java.sql.Types.INTEGER);
			cs.execute();
			// Retrieving and printing the results
			int sum = cs.getInt(3);
			int difference = cs.getInt(4);
			int product = cs.getInt(5);
			double quotient = cs.getDouble(6);

			System.out.println("Sum: " + sum);
			System.out.println("Difference: " + difference);
			System.out.println("Product: " + product);
			System.out.println("Quotient: " + quotient);

			sc.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			st.close();
			con.close();
		}
	}
}
