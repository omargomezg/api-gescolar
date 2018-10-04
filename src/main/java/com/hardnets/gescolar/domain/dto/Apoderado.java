package com.hardnets.gescolar.domain.dto;

import com.hardnets.gescolar.domain.dto.Telefono;
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
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String correo;
    private Integer estadoCivil;
    private List<Telefono> telefonos;
}
