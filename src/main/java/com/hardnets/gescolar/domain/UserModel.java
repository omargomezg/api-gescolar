package com.hardnets.gescolar.domain;

public class UserModel {
    public int id;
    public String descripcion;

    public UserModel(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
