package Service;

import DatabaseConnection.DatabaseConnection;
import Domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avsek on 4/3/2017.
 */
public class UserService {
    public User getUser(String username, String password){
        User user = null;

        String query = "select * from user where username=? and password=?";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setRole(rs.getString("role"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>();
        String query = "select * from user";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setRole(rs.getString("role"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public void addUser(String username, String password, String role){
        User user = new User();
        String query = "insert into user(username, password, role)values(?,?,?)";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);

        try {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteUser(String id){
        String query = "delete from user where id=?";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User editUser(int id){
        User user = null;

        String query = "select * from user where id=?";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void updateUser(User user){
        String query = "update user set username=?, password=?, role=? where id=?";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setInt(4, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
