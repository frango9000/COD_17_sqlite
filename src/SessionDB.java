package src;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author fsancheztemprano
 */
public class SessionDB {

    private Connection conn;

    public void connect() {
        conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:COD_17_sqlite/resources/chinook.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName()+".");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();                
                System.out.println("Connection to SQLite has been terminated.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
