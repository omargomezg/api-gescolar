package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Clase", schema = "dbo", catalog = "kimeltu")
public class ClaseEntity {
    private int clasId;
    private String clasNombre;
    private String clasAlumno;
    private short clasAnho;
    private short clasCurso;
    private byte clasMaxAlumnos;
    private Collection<AlumnoClaseEntity> tbSchmAlumnoClasesByClasId;
    private AlumnoEntity tbSchpAlumnoByClasAlumno;
    private CursosEntity tbSchmCursosByClasCurso;
    private Collection<PostulacionEntity> tbSchpPostulacionsByClasId;

    @Id
    @Column(name = "CLAS_Id")
    public int getClasId() {
        return clasId;
    }

    public void setClasId(int clasId) {
        this.clasId = clasId;
    }

    @Basic
    @Column(name = "CLAS_Nombre")
    public String getClasNombre() {
        return clasNombre;
    }

    public void setClasNombre(String clasNombre) {
        this.clasNombre = clasNombre;
    }

    @Basic
    @Column(name = "CLAS_Alumno")
    public String getClasAlumno() {
        return clasAlumno;
    }

    public void setClasAlumno(String clasAlumno) {
        this.clasAlumno = clasAlumno;
    }

    @Basic
    @Column(name = "CLAS_Anho")
    public short getClasAnho() {
        return clasAnho;
    }

    public void setClasAnho(short clasAnho) {
        this.clasAnho = clasAnho;
    }

    @Basic
    @Column(name = "CLAS_Curso")
    public short getClasCurso() {
        return clasCurso;
    }

    public void setClasCurso(short clasCurso) {
        this.clasCurso = clasCurso;
    }

    @Basic
    @Column(name = "CLAS_MaxAlumnos")
    public byte getClasMaxAlumnos() {
        return clasMaxAlumnos;
    }

    public void setClasMaxAlumnos(byte clasMaxAlumnos) {
        this.clasMaxAlumnos = clasMaxAlumnos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaseEntity that = (ClaseEntity) o;
        return clasId == that.clasId &&
                clasAnho == that.clasAnho &&
                clasCurso == that.clasCurso &&
                clasMaxAlumnos == that.clasMaxAlumnos &&
                Objects.equals(clasNombre, that.clasNombre) &&
                Objects.equals(clasAlumno, that.clasAlumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clasId, clasNombre, clasAlumno, clasAnho, clasCurso, clasMaxAlumnos);
    }

    @OneToMany(mappedBy = "tbSchpClaseByAcurClase")
    public Collection<AlumnoClaseEntity> getTbSchmAlumnoClasesByClasId() {
        return tbSchmAlumnoClasesByClasId;
    }

    public void setTbSchmAlumnoClasesByClasId(Collection<AlumnoClaseEntity> tbSchmAlumnoClasesByClasId) {
        this.tbSchmAlumnoClasesByClasId = tbSchmAlumnoClasesByClasId;
    }

    @ManyToOne
    @JoinColumn(name = "CLAS_Alumno", referencedColumnName = "ALMN_Rut", insertable = false, updatable = false)
    public AlumnoEntity getTbSchpAlumnoByClasAlumno() {
        return tbSchpAlumnoByClasAlumno;
    }

    public void setTbSchpAlumnoByClasAlumno(AlumnoEntity tbSchpAlumnoByClasAlumno) {
        this.tbSchpAlumnoByClasAlumno = tbSchpAlumnoByClasAlumno;
    }

    @ManyToOne
    @JoinColumn(name = "CLAS_Curso", referencedColumnName = "CURS_Id", nullable = false, insertable = false, updatable = false)
    public CursosEntity getTbSchmCursosByClasCurso() {
        return tbSchmCursosByClasCurso;
    }

    public void setTbSchmCursosByClasCurso(CursosEntity tbSchmCursosByClasCurso) {
        this.tbSchmCursosByClasCurso = tbSchmCursosByClasCurso;
    }

    @OneToMany(mappedBy = "tbSchpClaseByPostCursoPostulado")
    public Collection<PostulacionEntity> getTbSchpPostulacionsByClasId() {
        return tbSchpPostulacionsByClasId;
    }

    public void setTbSchpPostulacionsByClasId(Collection<PostulacionEntity> tbSchpPostulacionsByClasId) {
        this.tbSchpPostulacionsByClasId = tbSchpPostulacionsByClasId;
    }
}
