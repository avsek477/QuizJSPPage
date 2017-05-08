package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Avsek on 4/3/2017.
 */
public class DatabaseConnection {
    String url="jdbc:mysql://localhost:3306/table";
    String username = "root";
    String password = "";
    Connection con = null;

    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Database Connected");
    }

    public PreparedStatement getPreparedStatement(String query){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }
}
