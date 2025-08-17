package day13.Jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUsers {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demojdbc";
        String userName = "root";
        String pwd = "Root@123";
        String createTableSQL = "create table users("+"user_id INT Auto_increment primary key, "+"name varchar(50) not null, "+"email varchar(50) not null unique, "+"phone varchar(15) " +"); ";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection connection = DriverManager.getConnection(url, userName, pwd);
        	Statement statement = connection.createStatement();
        	statement.executeUpdate(createTableSQL);
        	System.out.println("users table created successfully in jdbcdemo!");
        	statement.close();
        	connection.close();
        } catch (ClassNotFoundException e) {
        	System.out.println("JDBC driver not found.");
        	e.printStackTrace();
        }catch (SQLException e) {
        	System.out.println("SQL error Occurred.");
        	e.printStackTrace();
        }
	}
}
