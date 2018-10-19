package com.hardnets.gescolar.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.text.WordUtils;

@NoArgsConstructor
@Getter
@Setter
public class AgentList {
    private String rut;
    private String nombre;
    private String correo;
    private String telefonoFijo;
    private String telefonoMovil;

    public AgentList(String rut, String nombre, String correo, String telefonoFijo, String telefonoMovil) {
        this.rut = rut;
        this.nombre = WordUtils.capitalizeFully(nombre);
        this.correo = correo.toLowerCase();
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
    }
}