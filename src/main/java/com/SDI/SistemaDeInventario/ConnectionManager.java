package com.SDI.SistemaDeInventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection = null;
    private static final String connectionString = "jdbc:sqlserver://localhost:1433;" +
            " databasename=SDI;integratedSecurity=true";

    public static Connection obtenerConexion() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection(connectionString);
        return connection;
    }
}
