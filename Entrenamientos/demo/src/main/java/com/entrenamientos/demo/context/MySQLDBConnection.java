package com.entrenamientos.demo.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnection {

    private static Connection connection;

    private MySQLDBConnection(){}

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://databasepostrgess.cpw4koqek8qf.us-east-1.rds.amazonaws.com:5432/gimnasio", "postgres", "Cachorritos11");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return MySQLDBConnection.connection;
    }
}
