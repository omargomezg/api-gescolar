package com.hardnets.gescolar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Apoderado {
    private String Rut;
    private String nombres;
    private String paterno;
    private String materno;
    private Date nacimiento;
    private String correo;
    private List<Telefono> telefonos;
}
