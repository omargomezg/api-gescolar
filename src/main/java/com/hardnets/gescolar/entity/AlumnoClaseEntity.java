package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_AlumnoClase", schema = "dbo")
public class AlumnoClaseEntity {
    private int acurId;
    private String acurAlumno;
    private Integer acurClase;
    private AlumnoEntity tbSchpAlumnoByAcurAlumno;
    private ClaseEntity tbSchpClaseByAcurClase;

    @Id
    @Column(name = "ACUR_Id")
    public int getAcurId() {
        return acurId;
    }

    public void setAcurId(int acurId) {
        this.acurId = acurId;
    }

    @Basic
    @Column(name = "ACUR_Alumno", columnDefinition = "nvarchar(10)")
    public String getAcurAlumno() {
        return acurAlumno;
    }

    public void setAcurAlumno(String acurAlumno) {
        this.acurAlumno = acurAlumno;
    }

    @Basic
    @Column(name = "ACUR_Clase")
    public Integer getAcurClase() {
        return acurClase;
    }

    public void setAcurClase(Integer acurClase) {
        this.acurClase = acurClase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoClaseEntity that = (AlumnoClaseEntity) o;
        return acurId == that.acurId &&
                Objects.equals(acurAlumno, that.acurAlumno) &&
                Objects.equals(acurClase, that.acurClase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acurId, acurAlumno, acurClase);
    }

    @ManyToOne
    @JoinColumn(name = "ACUR_Alumno", referencedColumnName = "ALMN_Rut", insertable = false, updatable = false)
    public AlumnoEntity getTbSchpAlumnoByAcurAlumno() {
        return tbSchpAlumnoByAcurAlumno;
    }

    public void setTbSchpAlumnoByAcurAlumno(AlumnoEntity tbSchpAlumnoByAcurAlumno) {
        this.tbSchpAlumnoByAcurAlumno = tbSchpAlumnoByAcurAlumno;
    }

    @ManyToOne
    @JoinColumn(name = "ACUR_Clase", referencedColumnName = "CLAS_Id", insertable = false, updatable = false)
    public ClaseEntity getTbSchpClaseByAcurClase() {
        return tbSchpClaseByAcurClase;
    }

    public void setTbSchpClaseByAcurClase(ClaseEntity tbSchpClaseByAcurClase) {
        this.tbSchpClaseByAcurClase = tbSchpClaseByAcurClase;
    }
}
