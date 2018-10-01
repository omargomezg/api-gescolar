package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Colegios", schema = "dbo", catalog = "kimeltu")
public class ColegiosEntity {
    private byte coleId;
    private String coleNombre;
    private boolean coleEstado;
    private Collection<PostulacionEntity> tbSchpPostulacionsByColeId;

    @Id
    @Column(name = "COLE_Id")
    public byte getColeId() {
        return coleId;
    }

    public void setColeId(byte coleId) {
        this.coleId = coleId;
    }

    @Basic
    @Column(name = "COLE_Nombre", columnDefinition = "nvarchar(200)")
    public String getColeNombre() {
        return coleNombre;
    }

    public void setColeNombre(String coleNombre) {
        this.coleNombre = coleNombre;
    }

    @Basic
    @Column(name = "COLE_Estado")
    public boolean isColeEstado() {
        return coleEstado;
    }

    public void setColeEstado(boolean coleEstado) {
        this.coleEstado = coleEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColegiosEntity that = (ColegiosEntity) o;
        return coleId == that.coleId &&
                coleEstado == that.coleEstado &&
                Objects.equals(coleNombre, that.coleNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coleId, coleNombre, coleEstado);
    }

    @OneToMany(mappedBy = "tbSchmColegiosByPostProcedencia")
    public Collection<PostulacionEntity> getTbSchpPostulacionsByColeId() {
        return tbSchpPostulacionsByColeId;
    }

    public void setTbSchpPostulacionsByColeId(Collection<PostulacionEntity> tbSchpPostulacionsByColeId) {
        this.tbSchpPostulacionsByColeId = tbSchpPostulacionsByColeId;
    }
}
