package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_LogAlumno", schema = "dbo", catalog = "kimeltu")
public class LogAlumnoEntity {
    private int lalmId;
    private String lalmTipo;
    private String lalmTexto;
    private Timestamp lalmFecha;
    private String lalmRut;
    private AlumnoEntity tbSchpAlumnoByLalmRut;

    @Id
    @Column(name = "LALM_Id")
    public int getLalmId() {
        return lalmId;
    }

    public void setLalmId(int lalmId) {
        this.lalmId = lalmId;
    }

    @Basic
    @Column(name = "LALM_Tipo", columnDefinition = "char(3)")
    public String getLalmTipo() {
        return lalmTipo;
    }

    public void setLalmTipo(String lalmTipo) {
        this.lalmTipo = lalmTipo;
    }

    @Basic
    @Column(name = "LALM_Texto", columnDefinition = "nvarchar(200)")
    public String getLalmTexto() {
        return lalmTexto;
    }

    public void setLalmTexto(String lalmTexto) {
        this.lalmTexto = lalmTexto;
    }

    @Basic
    @Column(name = "LALM_Fecha")
    public Timestamp getLalmFecha() {
        return lalmFecha;
    }

    public void setLalmFecha(Timestamp lalmFecha) {
        this.lalmFecha = lalmFecha;
    }

    @Basic
    @Column(name = "LALM_Rut", columnDefinition = "nvarchar(10)")
    public String getLalmRut() {
        return lalmRut;
    }

    public void setLalmRut(String lalmRut) {
        this.lalmRut = lalmRut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogAlumnoEntity that = (LogAlumnoEntity) o;
        return lalmId == that.lalmId &&
                Objects.equals(lalmTipo, that.lalmTipo) &&
                Objects.equals(lalmTexto, that.lalmTexto) &&
                Objects.equals(lalmFecha, that.lalmFecha) &&
                Objects.equals(lalmRut, that.lalmRut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lalmId, lalmTipo, lalmTexto, lalmFecha, lalmRut);
    }

    @ManyToOne
    @JoinColumn(name = "LALM_Rut", referencedColumnName = "ALMN_Rut", nullable = false, insertable = false, updatable = false)
    public AlumnoEntity getTbSchpAlumnoByLalmRut() {
        return tbSchpAlumnoByLalmRut;
    }

    public void setTbSchpAlumnoByLalmRut(AlumnoEntity tbSchpAlumnoByLalmRut) {
        this.tbSchpAlumnoByLalmRut = tbSchpAlumnoByLalmRut;
    }
}
