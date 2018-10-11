package com.hardnets.gescolar.domain.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Apoderado {
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
