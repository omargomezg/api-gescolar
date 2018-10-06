package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Cursos", schema = "dbo", catalog = "kimeltu")
public class CursosEntity {
    private short cursId;
    private String cursDescripcion;
    private boolean cursEstado;
    private byte cursOrdenDespliegue;
    private String cursClasificacion;
    private Collection<ClaseEntity> tbSchpClasesByCursId;
    private Collection<PostulacionEntity> tbSchpPostulacionsByCursId;

    @Id
    @Column(name = "CURS_Id")
    public short getCursId() {
        return cursId;
    }

    public void setCursId(short cursId) {
        this.cursId = cursId;
    }

    @Basic
    @Column(name = "CURS_Descripcion", columnDefinition = "nvarchar(50)")
    public String getCursDescripcion() {
        return cursDescripcion;
    }

    public void setCursDescripcion(String cursDescripcion) {
        this.cursDescripcion = cursDescripcion;
    }

    @Basic
    @Column(name = "CURS_Estado")
    public boolean isCursEstado() {
        return cursEstado;
    }

    public void setCursEstado(boolean cursEstado) {
        this.cursEstado = cursEstado;
    }

    @Basic
    @Column(name = "CURS_OrdenDespliegue")
    public byte getCursOrdenDespliegue() {
        return cursOrdenDespliegue;
    }
    public void setCursOrdenDespliegue(byte cursOrdenDespliegue) {
        this.cursOrdenDespliegue = cursOrdenDespliegue;
    }

    @Basic
    @Column(name = "CURS_Clasificacion", columnDefinition = "char(3)")
    public String getCursClasificacion() {
        return cursClasificacion;
    }

    public void setCursClasificacion(String cursClasificacion) {
        this.cursClasificacion = cursClasificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursosEntity that = (CursosEntity) o;
        return cursId == that.cursId &&
                cursEstado == that.cursEstado &&
                cursOrdenDespliegue == that.cursOrdenDespliegue &&
                Objects.equals(cursDescripcion, that.cursDescripcion) &&
                Objects.equals(cursClasificacion, that.cursClasificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursId, cursDescripcion, cursEstado, cursOrdenDespliegue, cursClasificacion);
    }

    @OneToMany(mappedBy = "tbSchmCursosByClasCurso")
    public Collection<ClaseEntity> getTbSchpClasesByCursId() {
        return tbSchpClasesByCursId;
    }

    public void setTbSchpClasesByCursId(Collection<ClaseEntity> tbSchpClasesByCursId) {
        this.tbSchpClasesByCursId = tbSchpClasesByCursId;
    }

    @OneToMany(mappedBy = "tbSchmCursosByPostCursando")
    public Collection<PostulacionEntity> getTbSchpPostulacionsByCursId() {
        return tbSchpPostulacionsByCursId;
    }

    public void setTbSchpPostulacionsByCursId(Collection<PostulacionEntity> tbSchpPostulacionsByCursId) {
        this.tbSchpPostulacionsByCursId = tbSchpPostulacionsByCursId;
    }
}
