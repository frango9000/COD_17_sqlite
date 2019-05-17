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
public class Autor {
    private int idAutor;
    private String nombre;
    private String nacionalidad;
    private Date fechaNacimiento;

    public Autor(int idAutor, String nombre, String nacionalidad, Date fechaNacimiento) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
}
