package com.hardnets.gescolar.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    private String rut;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
}
