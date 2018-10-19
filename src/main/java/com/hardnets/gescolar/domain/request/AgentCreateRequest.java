package com.hardnets.gescolar.domain.request;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentCreateRequest implements Serializable {
    private String rut;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String correo;
    private String genero;
    private String profesion;
    private Integer estadoCivil;
    private String telefonoFijo;
    private String telefonoMovil;
}