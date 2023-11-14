package edu.loyola.cs485.model.dao;

import edu.loyola.cs485.model.entity.AbstractEntity;

import java.sql.*;
public abstract class AbstractDAO<E extends AbstractEntity> {
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

    public abstract void create(E entity) throws SQLException;
    public abstract E read(int id) throws SQLException;
    public abstract void update(E entity) throws SQLException;
    public abstract void delete(E entity) throws SQLException;

}
