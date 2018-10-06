package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Descuentos", schema = "dbo")
public class DescuentosEntity {
    private short descId;
    private String descDescripcion;
    private byte descPorcentaje;
    private byte descServicio;
    private Boolean descEstado;
    private ServiciosEntity tbSchmServiciosByDescServicio;
    private Collection<DescuentoAlumnoEntity> tbSchpDescuentoAlumnosByDescId;

    @Id
    @Column(name = "DESC_Id")
    public short getDescId() {
        return descId;
    }

    public void setDescId(short descId) {
        this.descId = descId;
    }

    @Basic
    @Column(name = "DESC_Descripcion", columnDefinition = "nvarchar(50)")
    public String getDescDescripcion() {
        return descDescripcion;
    }

    public void setDescDescripcion(String descDescripcion) {
        this.descDescripcion = descDescripcion;
    }

    @Basic
    @Column(name = "DESC_Porcentaje")
    public byte getDescPorcentaje() {
        return descPorcentaje;
    }

    public void setDescPorcentaje(byte descPorcentaje) {
        this.descPorcentaje = descPorcentaje;
    }

    @Basic
    @Column(name = "DESC_Servicio")
    public byte getDescServicio() {
        return descServicio;
    }

    public void setDescServicio(byte descServicio) {
        this.descServicio = descServicio;
    }

    @Basic
    @Column(name = "DESC_Estado")
    public Boolean getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(Boolean descEstado) {
        this.descEstado = descEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescuentosEntity that = (DescuentosEntity) o;
        return descId == that.descId &&
                descPorcentaje == that.descPorcentaje &&
                descServicio == that.descServicio &&
                Objects.equals(descDescripcion, that.descDescripcion) &&
                Objects.equals(descEstado, that.descEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descId, descDescripcion, descPorcentaje, descServicio, descEstado);
    }

    @ManyToOne
    @JoinColumn(name = "DESC_Servicio", referencedColumnName = "SERV_Id", nullable = false, insertable = false, updatable = false)
    public ServiciosEntity getTbSchmServiciosByDescServicio() {
        return tbSchmServiciosByDescServicio;
    }

    public void setTbSchmServiciosByDescServicio(ServiciosEntity tbSchmServiciosByDescServicio) {
        this.tbSchmServiciosByDescServicio = tbSchmServiciosByDescServicio;
    }

    @OneToMany(mappedBy = "tbSchmDescuentosByDscaDescuento")
    public Collection<DescuentoAlumnoEntity> getTbSchpDescuentoAlumnosByDescId() {
        return tbSchpDescuentoAlumnosByDescId;
    }

    public void setTbSchpDescuentoAlumnosByDescId(Collection<DescuentoAlumnoEntity> tbSchpDescuentoAlumnosByDescId) {
        this.tbSchpDescuentoAlumnosByDescId = tbSchpDescuentoAlumnosByDescId;
    }
}
