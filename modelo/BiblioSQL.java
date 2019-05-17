/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.SessionDB;

/**
 *
 * @author NarF
 */
public class BiblioSQL {
    private final SessionDB session;
    
    public BiblioSQL(SessionDB session) {
        this.session = session;
    }
    
    public TreeMap<Integer,String> getGeneros(){
        TreeMap<Integer,String> generos = new TreeMap<>();
        String sql = "SELECT * FROM generos;";
        try {
            session.connect();
            Statement stmt = session.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                generos.put(rs.getInt(1), rs.getString(2));
            }
            generos.forEach((e,f) -> System.out.println(e + "" + f));
            session.close();
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generos;
    }
    public TreeMap<Integer,String> getPaises(){
        TreeMap<Integer,String> paises = new TreeMap<>();
        String sql = "SELECT * FROM paises;";
        try {
            session.connect();
            Statement stmt = session.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                paises.put(rs.getInt(1), rs.getString(2));
            }
            paises.forEach((e,f) -> System.out.println(e + "" + f));
            session.close();
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paises;
    }
        public TreeMap<Integer,Autor> getAutores() {
        TreeMap<Integer,Autor> autores = new TreeMap<>();
        String sql = "SELECT * FROM autores;";
        try {
            session.connect();
            Statement stmt = session.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Date date = null;
                try{
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    date = dateFormat.parse(rs.getString(3));
                }catch (ParseException ex) {
                    System.out.println("Exception Parsing Date!!!!");
                    Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
                Autor autor = new Autor(rs.getInt(1), rs.getString(2), date, rs.getInt(4));
                autores.put(rs.getInt(1), autor);
            }
            autores.forEach((e,f) -> System.out.println(f));
            session.close();
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return autores;
    }
    
    public void initializeBiblio(){//TEST!!!!
        File sql = new File("src/model/Tablas.sql");
        StringBuilder sqlcmd = new StringBuilder();
        try(Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream(sql)))){
            while(scan.hasNext()){
                sqlcmd.append(scan.nextLine()).append("\n");
            }
            session.connect();
            Statement stmt = session.getConn().createStatement();
            stmt.execute(sqlcmd.toString());
            session.close();
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void insertDemoData(){//TEST!!!!
        File sql = new File("src/model/DemoData.sql");
        StringBuilder sqlcmd = new StringBuilder();
        try(Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream(sql)))){
            while(scan.hasNext()){
                sqlcmd.append(scan.nextLine()).append("\n");
            }
            session.connect();
            Statement stmt = session.getConn().createStatement();
            stmt.execute(sqlcmd.toString());
            session.close();
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
