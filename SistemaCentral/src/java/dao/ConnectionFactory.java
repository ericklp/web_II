/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ericklopes
 */
public class ConnectionFactory {
public Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/pokemon?autoReconnect=true&useSSL=false", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
