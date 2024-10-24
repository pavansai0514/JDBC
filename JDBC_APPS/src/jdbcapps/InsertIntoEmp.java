
package jdbcapps;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertIntoEmp {

	public static void main(String[] args) throws Exception {
		Statement st = null;
		Connection con = null;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String qry1 = "";
		String qry2 = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employee";
			String user = "root";
			String password = "admin";
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			qry1 = "create table if not exists emp(id int ,name varchar(20),salary double,designation varchar(19),location varchar(20),adhar bigint,pancard varchar(20) , join_date date,mobile bigint ,dept varchar(10),manager_name varchar(12),image LONGBLOB)";
			System.out.println(st.executeUpdate(qry1));
			qry2 = "insert into emp values(?,?,?,?,?,?,?,?,?,?,?,?)";
			java.io.FileInputStream fin = new java.io.FileInputStream(new File("c:\\nature.jpg"));
			PreparedStatement pt = con.prepareStatement(qry2);
		    System.out.println("please Enter id:");
			pt.setInt(1, sc.nextInt());
			System.out.println("Please enter name:");
			pt.setString(2, sc.next());
			System.out.println("please enter salary:");
			pt.setDouble(3, sc.nextDouble());
			System.out.println("please Enter designation:");
			pt.setString(4, sc.next());
			System.out.println("please enter location:");
			pt.setString(5, sc.next());
			System.out.println("please enter adhar:");
			pt.setInt(6, sc.nextInt());
			System.out.println("please enter pancard:");
			pt.setString(7, sc.next());
			System.out.println("please enter join_date(yyyy-mm-dd):");
			pt.setString(8, sc.next());
			System.out.println("please enter mobile number:");
			pt.setInt(9, sc.nextInt());
			System.out.println("Pleaes enter department:");
			pt.setString(10, sc.next());
			System.out.println("please enter manager_name:");
			pt.setString(11, sc.next());
			pt.setBlob(12, fin, fin.available());
			int row = pt.executeUpdate();
			if (row > 0) {
				System.out.println("Values inserted successfully!");
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
