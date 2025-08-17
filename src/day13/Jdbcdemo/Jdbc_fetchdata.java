package day13.Jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_fetchdata{
    public static void main(String[] args) throws ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/demojdbc";
        String username = "root";
        String password = "Root@123";
        String query = "Select * from student";

        //load the driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        //establish connection
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful...");
            //create query
            Statement stmt = con.createStatement();

            //execute query
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("RollNo "+ "Name ");
            while(rs.next()){
                System.out.println(" "+rs.getInt("rollno")+"     "+rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}