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
    private String cursoPostula;
    private String cursoActual;
    private String colegioOrigen;
    private String estado;
    private String fechaPostulacion;
    private String fechaResolucion;
    private Alumno alumno;
    private ApoderadoPostulacion apoderado;
}
