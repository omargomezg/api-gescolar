package com.hardnets.gescolar.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Postulacion {
    private Long id;
    private Long year;
    private Alumno alumno;
    private ApoderadoPostulacion apoderado;
}
