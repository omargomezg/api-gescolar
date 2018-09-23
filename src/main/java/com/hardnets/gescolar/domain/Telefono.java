package com.hardnets.gescolar.domain;

public class Telefono {
    private int id;

    public int getId() {
        return id;
    }

    public Telefono(int id, String numero, String tipo) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Telefono() {

    }

    private String numero;
    private String tipo;
}
