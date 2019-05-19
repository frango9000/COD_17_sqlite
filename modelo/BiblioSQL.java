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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.SessionDB;

/**
 *
 * @author NarF
 */
public final class BiblioSQL {

    private final SessionDB session;

    private TreeMap<Integer, String> paises;
    private TreeMap<Integer, String> generos;
    private TreeMap<Integer, String> editoriales;
    private TreeMap<Integer, Autor> autores;
    private TreeMap<Integer, Libro> libros;

    public BiblioSQL(SessionDB session) {
        this.session = session;
    }

    public SessionDB getSession() {
        return session;
    }

    public boolean isValid() {
        ArrayList<String> tables = session.listTables();
        StringBuilder tablesString = new StringBuilder();
        tables.forEach(cnsmr -> tablesString.append(cnsmr).append("\n"));
        String model = "paises\n"
                + "autores\n"
                + "editoriales\n"
                + "generos\n"
                + "libros\n";
        return model.matches(tablesString.toString());
    }

    public TreeMap<Integer, String> getGeneros() {
        return generos;
    }

    public TreeMap<Integer, String> queryGeneros() {
        generos = new TreeMap<>();
        String sql = "SELECT * FROM generos;";
        try {
            session.connect();
            Statement stmt = session.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                generos.put(rs.getInt(1), rs.getString(2));
            }
            System.out.println(sql);
            //generos.forEach((e,f) -> System.out.println(e + "" + f));
            session.close();
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generos;
    }

    public TreeMap<Integer, String> getPaises() {
        return paises;
    }

    public TreeMap<Integer, String> queryPaises() {
        paises = new TreeMap<>();
        String sql = "SELECT * FROM paises;";
        try {
            session.connect();
            Statement stmt = session.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                paises.put(rs.getInt(1), rs.getString(2));
            }
            System.out.println(sql);
            //paises.forEach((e,f) -> System.out.println(e + "" + f));
            session.close();
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paises;
    }

    public TreeMap<Integer, String> getEditoriales() {
        return editoriales;
    }

    public TreeMap<Integer, String> queryEditoriales() {
        editoriales = new TreeMap<>();
        String sql = "SELECT * FROM editoriales;";
        try {
            session.connect();
            Statement stmt = session.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                editoriales.put(rs.getInt(1), rs.getString(2));
            }
            System.out.println(sql);
            //editoriales.forEach((e,f) -> System.out.println(e + "" + f));
            session.close();
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return editoriales;
    }

    public TreeMap<Integer, Autor> getAutores() {
        return autores;
    }

    public TreeMap<Integer, Autor> queryAutores() {
        autores = new TreeMap<>();
        String sql = "SELECT * FROM autores;";
        try {
            session.connect();
            Statement stmt = session.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Date date = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    date = dateFormat.parse(rs.getString(3));
                } catch (ParseException ex) {
                    System.out.println("Exception Parsing Date!!!!");
                    Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
                Autor autor = new Autor(rs.getInt(1), rs.getString(2), date, rs.getInt(4));
                autores.put(rs.getInt(1), autor);
            }
            System.out.println(sql);
            //autores.forEach((e,f) -> System.out.println(f));
            session.close();
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autores;
    }

    public TreeMap<Integer, Libro> getLibros() {
        return libros;
    }

    public TreeMap<Integer, Libro> queryLibros() {
        libros = new TreeMap<>();
        String sql = "SELECT * FROM libros;";
        try {
            session.connect();
            Statement stmt = session.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Date date = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    date = dateFormat.parse(rs.getString(3));
                } catch (ParseException ex) {
                    System.out.println("Exception Parsing Date!!!!");
                    Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
                Libro libro = new Libro(rs.getInt(1), rs.getString(2), date, rs.getInt(4), rs.getInt(5), rs.getInt(6));
                libros.put(rs.getInt(1), libro);
            }
            System.out.println(sql);
            //libros.forEach((e,f) -> System.out.println(f));
            session.close();
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libros;
    }

    public void initializeBiblio() {
        File sql = new File("src/modelo/Tablas.sql");
        StringBuilder sqlcmd = new StringBuilder();
        try (Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream(sql)))) {
            while (scan.hasNext()) {
                sqlcmd.append(scan.nextLine()).append("\n");
            }
            String multicmd = sqlcmd.toString();
            String[] cmds = multicmd.split(";");
            session.connect();
            for (String cmd : cmds) {
                Statement stmt = session.getConn().createStatement();
                stmt.executeUpdate(cmd + ";");
            }
            session.close();
        } catch (FileNotFoundException | SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertDemoData() {
        File sql = new File("src/modelo/DemoData.sql");
        StringBuilder sqlcmd = new StringBuilder();
        try (Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream(sql)))) {
            while (scan.hasNext()) {
                sqlcmd.append(scan.nextLine());
            }
            String multicmd = sqlcmd.toString();
            String[] cmds = multicmd.split(";");
            session.connect();
            for (String cmd : cmds) {
                Statement stmt = session.getConn().createStatement();
                stmt.executeUpdate(cmd + ";");
            }
            session.close();
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
