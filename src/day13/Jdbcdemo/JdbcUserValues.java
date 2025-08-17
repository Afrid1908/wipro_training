package day13.Jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUserValues {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demojdbc";
        String userName = "root";
        String pwd = "Root@123";
        String insertQuery = "Insert into users(name, email, phone) values(?,?,?)";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(url, userName, pwd);
        	PreparedStatement pst = con.prepareStatement(insertQuery);
        	pst.setString(1, "James");
        	pst.setString(2, "james@gmail.com");
        	pst.setString(3, "1234455897");
        	int rowsInserted = pst.executeUpdate();
        	if (rowsInserted > 0) {
        		System.out.println("A new user has been created successfully");
        	}
        	pst.close();
        	con.close();
        } catch (ClassNotFoundException e) {
        	System.out.println("JDBC driver not found.");
        	e.printStackTrace();
        } catch (SQLException e) {
        	System.out.println("SQL error occurred.");
        	e.printStackTrace();
        }
	}
}
