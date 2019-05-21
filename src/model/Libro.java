/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author NarF
 */
public class Libro {

    private int idLibro;
    private String titulo;
    private LocalDate fechaPublicacion;
    private int idAutor;
    private int idGenero;
    private int idEditorial;

    private static final String userDateFormat = "dd-MM-uuuu";
    private static final String dbDateFormat = "uuuu-MM-dd HH:mm:ss.SSS";

    public Libro(int idLibro, String titulo, String fechaPublicacion, int idAutor, int idGenero, int idEditorial) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.fechaPublicacion = LocalDate.parse(fechaPublicacion, DateTimeFormatter.ofPattern(dbDateFormat));
        this.idAutor = idAutor;
        this.idGenero = idGenero;
        this.idEditorial = idEditorial;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getFormatedDate() {
        return fechaPublicacion.format(DateTimeFormatter.ofPattern(userDateFormat));
    }

    public String getDbDate() {
        LocalDateTime ldt = LocalDateTime.of(fechaPublicacion, LocalTime.of(0, 0, 0, 0));
        return ldt.format(DateTimeFormatter.ofPattern(dbDateFormat));
    }

    public static String getDbDate(String ddMMuuuu) {
        LocalDateTime ldt = LocalDateTime.of(LocalDate.parse(ddMMuuuu, DateTimeFormatter.ofPattern(userDateFormat)), LocalTime.of(0, 0, 0, 0));
        return ldt.format(DateTimeFormatter.ofPattern(dbDateFormat));
    }

    public int getIdAutor() {
        return idAutor;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion + ", idAutor=" + idAutor + ", idGenero=" + idGenero + ", idEditorial=" + idEditorial + '}';
    }

}
