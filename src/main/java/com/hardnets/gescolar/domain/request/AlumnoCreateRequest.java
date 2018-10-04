package com.hardnets.gescolar.domain.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoCreateRequest {
    private String rut;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String estado;
    private String genero;
}