/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase con todos los comandos SQL utilizados por la biblioteca
 *
 * Javadocs detallados de query, insert, delete, update en la seccion de
 * comandos de la tabla libros ya que esta es la mas completa
 *
 * @author NarF
 */
public final class BiblioSQL {

    private final SessionDB session;

    /**
     * Listas para almacenar el contenido de las tablas
     */
    private TreeMap<Integer, String> paises;
    private TreeMap<Integer, String> generos;
    private TreeMap<Integer, String> editoriales;
    private TreeMap<Integer, Autor> autores;
    private TreeMap<Integer, Libro> libros;

    /**
     * Contructor, Recibe un Objeto SessionDB con el vinculo al archivo de la
     * base de datos
     *
     * @param session SessionDB
     */
    public BiblioSQL(SessionDB session) {
        this.session = session;
    }

    /**
     * Getter del parametro SessionDB session
     *
     * @return SessionDB session
     */
    public SessionDB getSession() {
        return session;
    }

    /**
     * devuelve true si la estructura de la DB activa es valida (coincide con la
     * inicializada)
     *
     * @return true si es valida
     */
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
                Autor autor = new Autor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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

    public int insertAutor(String autor, String fechaNacimiento, int idPais) {
        String sql = "INSERT INTO autores VALUES (NULL,'" + autor + "', '" + fechaNacimiento + "', '" + idPais + "');";
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

    public int updateAutor(int idAutor, String autor, String fechaNacimiento, int idPais) {
        String sql = "UPDATE autores SET nombre = '" + autor + "', idPais = '" + idPais + "', fechaNacimiento = '" + fechaNacimiento + "' WHERE idAutor = '" + idAutor + "';";
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

    public int deleteAutor(int idAutor) {
        String sql = "DELETE FROM autores WHERE idAutor = '" + idAutor + "';";
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

    /**
     * Getter para el mapa que contiene los Objetos libros leidos desde la base
     * de datos
     *
     * @return mapa libros
     */
    public TreeMap<Integer, Libro> getLibros() {
        return libros;
    }

    /**
     * Lee la tabla libros y por cada registro crea un Objeto Clase Libro y lo
     * agrega a el mapa 'libros' con su clave primaria (idLibro) como key
     * 
     * @return el mapa de libros 'libros'
     */
    public TreeMap<Integer, Libro> queryLibros() {
        libros = new TreeMap<>();
        String sql = "SELECT * FROM libros;";
        session.connect();
        try (Statement stmt = session.getConn().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Libro libro = new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
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

    /**
     * Agrega un nuevo libro a la Base de datos
     *
     * Recibimos todos los atributos del nuevo libro
     * 
     * 3 - Método insertar, recibe parámetros y devuelve el número de registros que insertó.
     *
     * en el comando SQL INSERT, el id va NULL para que sqlite asigne una clave
     * primaria nueva
     *
     * @param titulo
     * @param fechaPub
     * @param idAutor
     * @param idGenero
     * @param idEditorial
     * @return int: numero de filas afectadas
     */
    public int insertLibro(String titulo, String fechaPub, int idAutor, int idGenero, int idEditorial) {
        String sql = "INSERT INTO libros VALUES (NULL, '" + titulo + "', '" + fechaPub + "', '" + idAutor + "', '" + idGenero + "', '" + idEditorial + "');";
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

    /**
     * Metodo que edita un libro mediante el comando SQL UPDATE, recibiendo
     * todos los atributos del libro
     * 
     * 4 - Método borrar, recibe parámetros y devuelve número de registros borradas
     *
     * @param idLibro
     * @param titulo
     * @param fechaPub
     * @param idAutor
     * @param idGenero
     * @param idEditorial
     * @return int: numero de filas afectadas
     */
    public int updateLibro(int idLibro, String titulo, String fechaPub, int idAutor, int idGenero, int idEditorial) {
        String sql = "UPDATE libros SET titulo = '" + titulo + "', fechaPublicacion = '" + fechaPub + "', idAutor = '" + idAutor + "', idGenero = '" + idGenero + "', idEditorial = '" + idEditorial + "' WHERE idLibro = '" + idLibro + "';";
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

    /**
     * Metodo que recibe el id de un libro y ejecuta el comando DELETE en la DB
     *
     * Devuelve 1 si el comando elimina una fila, 0 si no hay modificacion
     * realizada
     *
     *
     * @param idLibro id del libro a borrar
     * @return int: numero de filas afectadas
     */
    public int deleteLibro(int idLibro) {
        String sql = "DELETE FROM libros WHERE idLibro = '" + idLibro + "';";
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

    /**
     * Metodo que crea las tablas y sus estructuras. Los comandos de creacion de
     * tablas estan en el archivo src/src/model/Tablas.sql
     * 
     * 1 - Método crear tabla
     *
     * Este metodo lee el archivo, lo divide en comandos y los ejecuta.
     */
    public boolean initializeBiblio() {
        boolean success = false;
        File sql = new File("src/src/model/Tablas.sql");
        StringBuilder sqlcmd = new StringBuilder();
        try (Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream(sql)))) {
            while (scan.hasNext()) {
                sqlcmd.append(scan.nextLine()).append("\n");
            }
            String multicmd = sqlcmd.toString();
            String[] cmds = multicmd.split(";");
            session.connect();
            try (Statement stmt = session.getConn().createStatement()) {
                for (String cmd : cmds) {
                    stmt.addBatch(cmd + ";");
                }
                stmt.executeBatch();
                success = true;
            }
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
        return success;
    }

    /**
     * Metodo que inserta datos de demostracion en la DB
     *
     * Los insert estan en el archivo src/src/model/DemoData.sql
     *
     * Este metodo lee el archivo, lo divide en comandos y los ejecuta.
     */
    public void insertDemoData() {
        File sql = new File("src/src/model/DemoData.sql");
        StringBuilder sqlcmd = new StringBuilder();
        try (Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream(sql)))) {
            while (scan.hasNext()) {
                sqlcmd.append(scan.nextLine());
            }
            String multicmd = sqlcmd.toString();
            String[] cmds = multicmd.split(";");
            session.connect();
            try (Statement stmt = session.getConn().createStatement()) {
                for (String cmd : cmds) {
                    stmt.addBatch(cmd + ";");
                }
                stmt.executeBatch();
            }
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(BiblioSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            session.close();
        }
    }

    /**
     * Podemos utilizar esta clase como singleton para reducir su uso en
     * constructores de la gui, aunque se solucionaria haciendola static,
     * posiblemente se lleguen a conectar 2 bibliotecas distintas asi que
     * reservo las modificaciones para entonces
     */
    private static BiblioSQL openInstance;

    public static BiblioSQL getOpenInstance() {
        return openInstance;
    }

    public void setOpenInstance() {
        BiblioSQL.openInstance = this;
    }
}
