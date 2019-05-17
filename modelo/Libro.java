/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author NarF
 */
public class Libro {
    private int idLibro;
    private String titulo;
    private String genero;
    private Autor autor;
    private String editorial;
    private Date fechaPublicacion;

    public Libro(int idLibro, String titulo, String genero, Autor autor, String editorial, Date fechaPublicacion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
    }
    
    
    
}
