package Exo.utils;

import java.sql.*;
public class DatabaseManager {

    public static Connection getPostgreSQLConnection() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/student_jbdc";
        String user = "postgres";
        String password = "0203";

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

}