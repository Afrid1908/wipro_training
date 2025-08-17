package day13.Jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_Insertdata {
         public static void main(String[] args) throws SQLException {
	        String url = "jdbc:mysql://localhost:3306/demojdbc";
	        String userName = "root";
	        String password = "ROot@123";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            System.err.println("MySQL driver not found");
	            e.printStackTrace();
	            return;
	        }

	        try (Connection con = DriverManager.getConnection(url, userName, password);
	             Statement st = con.createStatement()) {

	            // Create table
	            String user = "CREATE TABLE IF NOT EXISTS student (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20))";
	            st.executeUpdate(user);
	            System.out.println("Table 'student' is created.");

	            // Insert data using PreparedStatement
	            String val = "INSERT INTO student(name) VALUES (?)";
	            try (PreparedStatement ps = con.prepareStatement(val)) {
	                ps.setString(1, "Afrid");
	                ps.addBatch();

	                int[] arr = ps.executeBatch();
	                System.out.printf("Inserted rows: %d%n", java.util.stream.IntStream.of(arr).filter(c -> c > 0).count());
	            }

	            // Fetch and display data
	            String query = "SELECT * FROM student";
	            try (ResultSet rs = st.executeQuery(query)) {
	                while (rs.next()) {
	                    int id = rs.getInt("id");
	                    String name = rs.getString("name");
	                    System.out.println("ID: " + id + ", Name: " + name);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
