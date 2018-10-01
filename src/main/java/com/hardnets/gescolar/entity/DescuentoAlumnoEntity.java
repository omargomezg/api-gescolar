package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_DescuentoAlumno", schema = "dbo", catalog = "kimeltu")
public class DescuentoAlumnoEntity {
    private int dscaId;
    private String dscaAlumno;
    private short dscaDescuento;
    private boolean dscaEstado;
    private AlumnoEntity tbSchpAlumnoByDscaAlumno;
    private DescuentosEntity tbSchmDescuentosByDscaDescuento;

    @Id
    @Column(name = "DSCA_Id")
    public int getDscaId() {
        return dscaId;
    }

    public void setDscaId(int dscaId) {
        this.dscaId = dscaId;
    }

    @Basic
    @Column(name = "DSCA_Alumno", columnDefinition = "nvarchar(10)")
    public String getDscaAlumno() {
        return dscaAlumno;
    }

    public void setDscaAlumno(String dscaAlumno) {
        this.dscaAlumno = dscaAlumno;
    }

    @Basic
    @Column(name = "DSCA_Descuento")
    public short getDscaDescuento() {
        return dscaDescuento;
    }

    public void setDscaDescuento(short dscaDescuento) {
        this.dscaDescuento = dscaDescuento;
    }

    @Basic
    @Column(name = "DSCA_Estado")
    public boolean isDscaEstado() {
        return dscaEstado;
    }

    public void setDscaEstado(boolean dscaEstado) {
        this.dscaEstado = dscaEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescuentoAlumnoEntity that = (DescuentoAlumnoEntity) o;
        return dscaId == that.dscaId &&
                dscaDescuento == that.dscaDescuento &&
                dscaEstado == that.dscaEstado &&
                Objects.equals(dscaAlumno, that.dscaAlumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dscaId, dscaAlumno, dscaDescuento, dscaEstado);
    }

    @ManyToOne
    @JoinColumn(name = "DSCA_Alumno", referencedColumnName = "ALMN_Rut", nullable = false, insertable = false, updatable = false)
    public AlumnoEntity getTbSchpAlumnoByDscaAlumno() {
        return tbSchpAlumnoByDscaAlumno;
    }

    public void setTbSchpAlumnoByDscaAlumno(AlumnoEntity tbSchpAlumnoByDscaAlumno) {
        this.tbSchpAlumnoByDscaAlumno = tbSchpAlumnoByDscaAlumno;
    }

    @ManyToOne
    @JoinColumn(name = "DSCA_Descuento", referencedColumnName = "DESC_Id", nullable = false, insertable = false, updatable = false)
    public DescuentosEntity getTbSchmDescuentosByDscaDescuento() {
        return tbSchmDescuentosByDscaDescuento;
    }

    public void setTbSchmDescuentosByDscaDescuento(DescuentosEntity tbSchmDescuentosByDscaDescuento) {
        this.tbSchmDescuentosByDscaDescuento = tbSchmDescuentosByDscaDescuento;
    }
}
