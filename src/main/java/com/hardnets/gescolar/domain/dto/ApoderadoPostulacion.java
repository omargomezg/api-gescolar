package com.hardnets.gescolar.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApoderadoPostulacion {
    private String rut;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
}
