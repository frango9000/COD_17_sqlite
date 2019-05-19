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
        session.connect();
        try (Statement stmt = session.getConn().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                generos.put(rs.getInt(1), rs.getString(2));
            }
            System.out.println(sql);
            //generos.forEach((e,f) -> System.out.println(e + "" + f));
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return generos;
    }

    public int insertGenero(String genero) {
        String sql = "INSERT INTO generos  VALUES (NULL,'" + genero + "');";
        session.connect();
        int rows = 0;
        try (Statement stmt = session.getConn().createStatement()) {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return rows;
    }

    public int updateGenero(int idGenero, String genero) {
        String sql = "UPDATE generos SET genero = '" + genero + "' WHERE idGenero = '" + idGenero + "';";
        session.connect();
        int rows = 0;
        try (Statement stmt = session.getConn().createStatement()) {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return rows;
    }

    public int deleteGenero(int idGenero) {
        String sql = "DELETE FROM generos WHERE idGenero = '" + idGenero + "';";
        session.connect();
        int rows = 0;
        try (Statement stmt = session.getConn().createStatement()) {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return rows;
    }

    public TreeMap<Integer, String> getPaises() {
        return paises;
    }

    public TreeMap<Integer, String> queryPaises() {
        paises = new TreeMap<>();
        String sql = "SELECT * FROM paises;";
        session.connect();
        try (Statement stmt = session.getConn().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                paises.put(rs.getInt(1), rs.getString(2));
            }
            System.out.println(sql);
            //paises.forEach((e,f) -> System.out.println(e + "" + f));
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return paises;
    }

    public int insertPais(String pais) {
        String sql = "INSERT INTO paises VALUES (NULL,'" + pais + "');";
        session.connect();
        int rows = 0;
        try (Statement stmt = session.getConn().createStatement()) {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return rows;
    }

    public int updatePais(int idPais, String pais) {
        String sql = "UPDATE paises SET pais = '" + pais + "' WHERE idPais = '" + idPais + "';";
        session.connect();
        int rows = 0;
        try (Statement stmt = session.getConn().createStatement()) {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return rows;
    }

    public int deletePais(int idPais) {
        String sql = "DELETE FROM paises WHERE idPais = '" + idPais + "';";
        session.connect();
        int rows = 0;
        try (Statement stmt = session.getConn().createStatement()) {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return rows;
    }

    public int insertEditorial(String editorial) {
        String sql = "INSERT INTO editoriales VALUES (NULL,'" + editorial + "');";
        session.connect();
        int rows = 0;
        try (Statement stmt = session.getConn().createStatement()) {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return rows;
    }

    public int updateEditorial(int idEditorial, String editorial) {
        String sql = "UPDATE editoriales SET editorial = '" + editorial + "' WHERE idEditorial = '" + idEditorial + "';";
        session.connect();
        int rows = 0;
        try (Statement stmt = session.getConn().createStatement()) {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return rows;
    }

    public int deleteEditorial(int idEditorial) {
        String sql = "DELETE FROM editoriales WHERE idEditorial = '" + idEditorial + "';";
        session.connect();
        int rows = 0;
        try (Statement stmt = session.getConn().createStatement()) {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return rows;
    }

    public TreeMap<Integer, String> getEditoriales() {
        return editoriales;
    }

    public TreeMap<Integer, String> queryEditoriales() {
        editoriales = new TreeMap<>();
        String sql = "SELECT * FROM editoriales;";
        session.connect();
        try (Statement stmt = session.getConn().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                editoriales.put(rs.getInt(1), rs.getString(2));
            }
            System.out.println(sql);
            //editoriales.forEach((e,f) -> System.out.println(e + "" + f));
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return editoriales;
    }

    public TreeMap<Integer, Autor> getAutores() {
        return autores;
    }

    public TreeMap<Integer, Autor> queryAutores() {
        autores = new TreeMap<>();
        String sql = "SELECT * FROM autores;";
        session.connect();
        try (Statement stmt = session.getConn().createStatement()) {
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
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return autores;
    }

    public TreeMap<Integer, Libro> getLibros() {
        return libros;
    }

    public TreeMap<Integer, Libro> queryLibros() {
        libros = new TreeMap<>();
        String sql = "SELECT * FROM libros;";
        session.connect();
        try (Statement stmt = session.getConn().createStatement()) {
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
        } catch (SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
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
