/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Quang Nguyen
 */
public class DAO {
    private static String connectionString = "jdbc:sqlserver://localhost:1434;databaseName=test;user=sa;password=Duckie@01;encrypt=false";

    private Connection _connect;

    public DAO() {

        _connect = initializeDBConnection();
    }

    private Connection initializeDBConnection() {
        try {
            String password = "";
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println("OK");
            return connection;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
