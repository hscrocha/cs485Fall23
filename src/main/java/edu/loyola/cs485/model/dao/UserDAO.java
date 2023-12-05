package edu.loyola.cs485.model.dao;

import edu.loyola.cs485.model.entity.User;

import java.sql.*;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {

    public User login(String login, String password) throws SQLException{
        User logged = null;
        String sql = "SELECT * FROM user WHERE login = '"+login
                +"' AND password = '"+password+"' ";
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            logged = new User();
            logged.setID( rs.getInt("id_user") );
            logged.setLogin( rs.getString("login") );
            logged.setPassword( rs.getString("password") );
            logged.setPermission( rs.getInt("permission") );
        }
        return logged;
    }

    @Override
    public void create(User entity) throws SQLException {

    }

    @Override
    public User read(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(User entity) throws SQLException {

    }

    @Override
    public void delete(User entity) throws SQLException {

    }

    @Override
    public List<User> list() throws SQLException {
        return null;
    }
}
