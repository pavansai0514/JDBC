package jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DropColumn {

	public static int deletecolumn(String str,Statement st) throws SQLException
	{
		
		return st.executeUpdate("Alter table emp drop column "+str);

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Statement st = null;
		Connection con = null;


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employees";
			String user = "root";
			String password = "admin";
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			
      String colname=sc.next();
      
  System.out.println(deletecolumn(colname,st)); 
      
        
       
		
		}

		catch (SQLException ex) {

			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {

		}
	}

}
