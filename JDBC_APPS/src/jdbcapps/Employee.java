package jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private String designation;

	Employee(int id, String name, double salary, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public static void insert(Employee obj, Statement st) throws SQLException {
		// String qry1 = "insert into employee values(3,'sai',345,'hr')";
		String qry1 = "INSERT INTO employee (id, name, salary,designation) VALUES (" + obj.getId() + ", '"
				+ obj.getName() + "', " + obj.getSalary() + ", '" + obj.getDesignation() + "')";
		System.out.println(st.executeUpdate(qry1));
		System.out.println("values inserted");
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		//Employee emp1 = new Employee(sc.nextInt(), sc.next(), sc.nextDouble(), sc.next());

		Statement st = null;
		Connection con = null;
		String qry1 = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employee";
			String user = "root";
			String password = "admin";
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			qry1 = "create table if not exists employee(id int ,name varchar(20),salary double,designation varchar(10))";
			System.out.println(st.executeUpdate(qry1));
			System.out.println("Table created");
			
			System.out.println("Enter number of empoloyees you want to insert");
			int n = sc.nextInt();
			while (n > 0) {
				System.out.println("Enter emp id:");
				int id = sc.nextInt();
				System.out.println("Enter emp id:");
				String name = sc.next();
				System.out.println("Enter emp id:");
				double salary = sc.nextDouble();
				System.out.println("Enter emp id:");
				String designation = sc.next();
	             Employee emp=new Employee(id,name,salary,designation);
	             insert(emp, st);
	             n--;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {

		}
	}

}
