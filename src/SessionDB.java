package src;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author fsancheztemprano
 */
public class SessionDB {

    private Connection conn;
    private String dbUrl;
    private File db;

    public SessionDB() {
        dbUrl = "jdbc:sqlite:COD_17_sqlite/resources/chinook.db";
        db=new File(dbUrl.substring(dbUrl.lastIndexOf(":")));
    }

    public SessionDB(String url) {
        this.dbUrl = "jdbc:sqlite:"+url;
        db=new File(url);
    }

    public SessionDB(File db) {
        this.db = db;
        dbUrl="jdbc:sqlite:"+db.getAbsolutePath();
    }
    
    public boolean exists(){
        return db.exists();
    }
    
    
    public void connect() {
        conn = null;
        try {
            // db parameters
            
            // create a connection to the database
            conn = DriverManager.getConnection(dbUrl);

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
