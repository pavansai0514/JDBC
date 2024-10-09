package jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertUsingDynamicValues {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
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
			
        int id=sc.nextInt();
        String name=sc.next();
        double salary=sc.nextDouble();
        
        
			//qry1 = "insert into emp values("+id+","+name+","+salary+")";
			 qry1 = "INSERT INTO emp (id, name, salary) VALUES (" + id + ", '" + name + "', " + salary + ")";
			System.out.println(qry1);
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
