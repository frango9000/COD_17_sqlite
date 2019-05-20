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
public class Autor {

    private int idAutor;
    private String nombre;
    private LocalDate fechaNacimiento;
    private int idPais;

    public Autor(int idAutor, String nombre, LocalDate fechaNacimiento, int idPais) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.idPais = idPais;
    }

    public Autor(int idAutor, String nombre, String fechaNacimiento, int idPais) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS"));
        this.idPais = idPais;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFormatedDate() {
        return fechaNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"));
    }

    public String getDbDate() {
        LocalDateTime ldt = LocalDateTime.of(fechaNacimiento, LocalTime.of(0, 0, 0, 0));
        return ldt.format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS"));
    }
    
    public static String getDbDate(String ddMMuuuu){
        LocalDateTime ldt = LocalDateTime.of(LocalDate.parse(ddMMuuuu, DateTimeFormatter.ofPattern("dd-MM-uuuu")), LocalTime.of(0, 0, 0, 0));
        return ldt.format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS"));
    }

    public int getIdPais() {
        return idPais;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", idPais=" + idPais + '}';
    }

}
