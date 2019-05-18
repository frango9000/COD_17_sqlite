/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author NarF
 */
public class Libro {
    private int idLibro;
    private String titulo;
    private Date fechaPublicacion;
    private Autor autor;
    private int idAutor;
    private String genero;
    private int idGenero;
    private String editorial;
    private int idEditorial;

    public Libro(int idLibro, String titulo, Date fechaPublicacion, Autor autor, String genero, String editorial) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
    }

    public Libro(int idLibro, String titulo, Date fechaPublicacion, int idAutor, int idGenero, int idEditorial) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
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

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }
    
    public String getFormatedDate(){
       GregorianCalendar cal = new GregorianCalendar();
       cal.setTime(fechaPublicacion);
       return String.format("%02d/%02d/%04d", cal.get(Calendar.DATE), cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR));
    }

    public Autor getAutor() {
        return autor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public String getGenero() {
        return genero;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getIdEditorial() {
        return idEditorial;
    }
    
    

    
    
    
}
