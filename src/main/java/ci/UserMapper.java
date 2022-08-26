package ci;

import DB.DBconnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class    UserMapper {

    Connection con = null;

    public User getUserName() {
        User user = null;
        try {
            con = DBconnector.connection();
            String SQL = "SELECT id,fname,lname FROM startcode_test.usertable;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                user = new User(fname, lname);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getDetailsOfSpecificUser(int userID) {
        User user = null;
        try {
            con = DBconnector.connection();
            String SQL = "SELECT * FROM startcode_test.usertable WHERE id =" + userID;
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String password = rs.getString("pw");
                int phoneNumber = rs.getInt("phone");
                String address = rs.getString("address");
                user = new User(fname, lname, password, phoneNumber, address);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(int userID, String fname) {

        try {
            String SQL = "UPDATE startcode_test.usertable SET fname =" + fname + " WHERE id ="+userID;
            con = DBconnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
