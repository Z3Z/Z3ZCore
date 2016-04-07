package net.core.main.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {
    private final String host, port, database, user, password;

    private Connection con;

    public SQL(String host, String port, String database, String user, String password) {
    	this.host= host;
    	this.port= port;
        this.database= database;
        this.user= user;
        this.password= password;

        connect();
    }

    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true",user, password);
            System.out.println("[CoreSQL] The connection to the database has been made!");
        } catch (SQLException e) {
            System.out.println("[CoreSQL] The connection to MySQL couldn't be made! reason: " + e.getMessage());
        }
    }
    
    public void close() {
        try {
            if (con != null) {
                con.close();
                System.out.println("[MySQL] The connection to MySQL is ended successfully!");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public PreparedStatement prepareStatement(String qry) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(qry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public void update(PreparedStatement statement) {
        try {
            statement.executeUpdate();    
        } catch (SQLException e) {
            connect();
            e.printStackTrace();
        }finally{
           try {
             statement.close();
           } catch (SQLException e) {
             e.printStackTrace();
           }
    }
    }

    public boolean hasConnection() {
        return con != null;
    }

    public ResultSet query(PreparedStatement statement) {
        try {
            return statement.executeQuery();
        } catch (SQLException e) {
            connect();
            e.printStackTrace();
        }
        return null;
    }
}
