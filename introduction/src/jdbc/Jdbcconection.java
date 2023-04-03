package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcconection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + port + "/Qadbt", "root", "admin");
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("Select * from Employeeinfo where name='ram'");
		while (result.next()) {
			System.out.println(result.getString("username"));
			System.out.println(result.getString("location"));
		}
	}

}
