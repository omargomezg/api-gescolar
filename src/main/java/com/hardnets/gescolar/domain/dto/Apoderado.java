package com.hardnets.gescolar.domain.dto;

import com.hardnets.gescolar.domain.dto.Telefono;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Apoderado {
    private String rut;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String correo;
    private Integer estadoCivil;
    private List<Telefono> telefonos;

    public Apoderado() {    
        // constructor
    }

}
