package src;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author fsancheztemprano
 */
public class SessionDB {

    private Connection conn;
    private String dbUrl;
    private File db;

    public SessionDB() {
        dbUrl = "jdbc:sqlite:COD_17_sqlite/resources/biblio.db";
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

    public Connection getConn() {
        return conn;
    }
    
    public boolean exists(){
        return db.exists();
    }
    
    
    public void connect() {
        conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl);

            System.out.println("Connection to " + conn.getMetaData().getDriverName()+" has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }    
    
    public void close() {
        try {
            if (conn != null) {
                conn.close();                
                System.out.println("Connection has been terminated.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int numOfTables()  {
        String sql = "SELECT name FROM  sqlite_master  WHERE type ='table' AND name NOT LIKE 'sqlite_%';";
        int count=0;
        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                count++;
            }
            close();
        } catch (SQLException ex) {
            Logger.getLogger(SessionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public ArrayList<String> listTables()  {
        String sql = "SELECT name FROM  sqlite_master  WHERE type ='table' AND name NOT LIKE 'sqlite_%';";
        ArrayList<String> tableNames = new ArrayList<>();
        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                tableNames.add(rs.getString(1));
            }
            close();
        } catch (SQLException ex) {
            Logger.getLogger(SessionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableNames.trimToSize();
        return tableNames;
    }
    
    public void printTables(){
        ArrayList<String> tablenames = listTables();
        tablenames.forEach( (name) -> System.out.println(name) );
    }
}
