package com.hardnets.gescolar.domain;

import java.util.Date;
import java.util.List;

public class Apoderado {
    private String rut;
    private String nombres;
    private String paterno;
    private String materno;
    private Date nacimiento;
    private String correo;
    private List<Telefono> telefonos;

    public Apoderado(String rut, String nombres, String paterno, String materno, Date nacimiento, String correo, List<Telefono> telefonos) {
        this.rut = rut;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.nacimiento = nacimiento;
        this.correo = correo;
        this.telefonos = telefonos;
    }

    public Apoderado() {
        super();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
}
