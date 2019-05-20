/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author NarF
 */
public class Autor {

    private int idAutor;
    private String nombre;
    private Date fechaNacimiento;
    private int idPais;
    private String pais;

    public Autor(int idAutor, String nombre, Date fechaNacimiento, int idPais) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.idPais = idPais;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFormatedDate() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fechaNacimiento);
        return String.format("%02d/%02d/%04d", cal.get(Calendar.DATE), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
    }    

    public int getIdPais() {
        return idPais;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", idPais=" + idPais + '}';
    }

}
