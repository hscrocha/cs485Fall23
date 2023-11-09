package edu.loyola.cs485.model.dao;

import java.sql.*;
public abstract class AbstractDAO {
    protected String ConUrl = "jdbc:mysql://localhost";
    protected String Port = "3306";
    protected String Database = "music_db";
    protected String Username = "root";
    protected String Password = "csforever";

    public Connection getConnection() throws SQLException{
        String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                +"&password="+Password;
        Connection con = DriverManager.getConnection(url);
        return con;
    }

}
