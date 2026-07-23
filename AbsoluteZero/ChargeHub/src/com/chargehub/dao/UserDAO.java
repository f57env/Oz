package com.chargehub.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chargehub.config.DBConnection;
import com.chargehub.entity.User;

public class UserDAO {

    public boolean registerUser(User user) {

        String query = "INSERT INTO users(full_name,email,mobile,password,role) VALUES(?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getMobile());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                return true;
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



public User loginByEmail(String email, String password) {

    String query = "SELECT * FROM users WHERE email=? AND password=?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            User user = new User();

            user.setUserId(rs.getInt("user_id"));
            user.setFullName(rs.getString("full_name"));
            user.setEmail(rs.getString("email"));
            user.setMobile(rs.getString("mobile"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));

            return user;
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return null;
}
}