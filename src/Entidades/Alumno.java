/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;


public class Alumno {
     private int idAlumno;
    private int dni;
    private String nombre;
    private String apellido;
    private Date fechaN;
    private boolean estado;

    public Alumno(int idAlumno, int dni, String nombre, String apellido, Date fechaN, boolean estado) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaN = fechaN;
        this.estado = estado;
    }

    public Alumno(int dni, String nombre, String apellido, Date fechaN, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaN = fechaN;
        this.estado = estado;
    }


    

    public Alumno() {
    }


    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
