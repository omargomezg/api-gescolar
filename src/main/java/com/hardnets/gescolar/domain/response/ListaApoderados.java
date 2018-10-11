package com.hardnets.gescolar.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListaApoderados {
    private String rut;
    private String nombre;
    private String correo;
    private String telefonoFijo;
    private String telefonoMovil;
}