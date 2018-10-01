package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Postulacion", schema = "dbo", catalog = "kimeltu")
public class PostulacionEntity {
    private short postId;
    private int postYear;
    private Integer postCursoPostulado;
    private short postCursando;
    private Byte postProcedencia;
    private String postAlumno;
    private String postEstado;
    private String postColegio;
    private Integer postBoleta;
    private Timestamp postFechaPostulacion;
    private Timestamp postFechaResolucion;
    private ClaseEntity tbSchpClaseByPostCursoPostulado;
    private CursosEntity tbSchmCursosByPostCursando;
    private ColegiosEntity tbSchmColegiosByPostProcedencia;
    private AlumnoEntity tbSchpAlumnoByPostAlumno;
    private BoletaServiciosEntity tbSchpBoletaServiciosByPostBoleta;

    @Id
    @Column(name = "POST_Id")
    public short getPostId() {
        return postId;
    }

    public void setPostId(short postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "POST_Year", columnDefinition = "numeric(4,0)")
    public int getPostYear() {
        return postYear;
    }

    public void setPostYear(int postYear) {
        this.postYear = postYear;
    }

    @Basic
    @Column(name = "POST_CursoPostulado")
    public Integer getPostCursoPostulado() {
        return postCursoPostulado;
    }

    public void setPostCursoPostulado(Integer postCursoPostulado) {
        this.postCursoPostulado = postCursoPostulado;
    }

    @Basic
    @Column(name = "POST_Cursando")
    public short getPostCursando() {
        return postCursando;
    }

    public void setPostCursando(short postCursando) {
        this.postCursando = postCursando;
    }

    @Basic
    @Column(name = "POST_Procedencia")
    public Byte getPostProcedencia() {
        return postProcedencia;
    }

    public void setPostProcedencia(Byte postProcedencia) {
        this.postProcedencia = postProcedencia;
    }

    @Basic
    @Column(name = "POST_Alumno", columnDefinition = "nvarchar(10)")
    public String getPostAlumno() {
        return postAlumno;
    }

    public void setPostAlumno(String postAlumno) {
        this.postAlumno = postAlumno;
    }

    @Basic
    @Column(name = "POST_Estado", columnDefinition = "nchar(1)")
    public String getPostEstado() {
        return postEstado;
    }

    public void setPostEstado(String postEstado) {
        this.postEstado = postEstado;
    }

    @Basic
    @Column(name = "POST_Colegio", columnDefinition = "nvarchar(300)")
    public String getPostColegio() {
        return postColegio;
    }

    public void setPostColegio(String postColegio) {
        this.postColegio = postColegio;
    }

    @Basic
    @Column(name = "POST_Boleta")
    public Integer getPostBoleta() {
        return postBoleta;
    }

    public void setPostBoleta(Integer postBoleta) {
        this.postBoleta = postBoleta;
    }

    @Basic
    @Column(name = "POST_FechaPostulacion")
    public Timestamp getPostFechaPostulacion() {
        return postFechaPostulacion;
    }

    public void setPostFechaPostulacion(Timestamp postFechaPostulacion) {
        this.postFechaPostulacion = postFechaPostulacion;
    }

    @Basic
    @Column(name = "POST_FechaResolucion")
    public Timestamp getPostFechaResolucion() {
        return postFechaResolucion;
    }

    public void setPostFechaResolucion(Timestamp postFechaResolucion) {
        this.postFechaResolucion = postFechaResolucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostulacionEntity that = (PostulacionEntity) o;
        return postId == that.postId &&
                postYear == that.postYear &&
                postCursando == that.postCursando &&
                Objects.equals(postCursoPostulado, that.postCursoPostulado) &&
                Objects.equals(postProcedencia, that.postProcedencia) &&
                Objects.equals(postAlumno, that.postAlumno) &&
                Objects.equals(postEstado, that.postEstado) &&
                Objects.equals(postColegio, that.postColegio) &&
                Objects.equals(postBoleta, that.postBoleta) &&
                Objects.equals(postFechaPostulacion, that.postFechaPostulacion) &&
                Objects.equals(postFechaResolucion, that.postFechaResolucion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postYear, postCursoPostulado, postCursando, postProcedencia, postAlumno, postEstado, postColegio, postBoleta, postFechaPostulacion, postFechaResolucion);
    }

    @ManyToOne
    @JoinColumn(name = "POST_CursoPostulado", referencedColumnName = "CLAS_Id", insertable = false, updatable = false)
    public ClaseEntity getTbSchpClaseByPostCursoPostulado() {
        return tbSchpClaseByPostCursoPostulado;
    }

    public void setTbSchpClaseByPostCursoPostulado(ClaseEntity tbSchpClaseByPostCursoPostulado) {
        this.tbSchpClaseByPostCursoPostulado = tbSchpClaseByPostCursoPostulado;
    }

    @ManyToOne
    @JoinColumn(name = "POST_Cursando", referencedColumnName = "CURS_Id", nullable = false, insertable = false, updatable = false)
    public CursosEntity getTbSchmCursosByPostCursando() {
        return tbSchmCursosByPostCursando;
    }

    public void setTbSchmCursosByPostCursando(CursosEntity tbSchmCursosByPostCursando) {
        this.tbSchmCursosByPostCursando = tbSchmCursosByPostCursando;
    }

    @ManyToOne
    @JoinColumn(name = "POST_Procedencia", referencedColumnName = "COLE_Id", insertable = false, updatable = false)
    public ColegiosEntity getTbSchmColegiosByPostProcedencia() {
        return tbSchmColegiosByPostProcedencia;
    }

    public void setTbSchmColegiosByPostProcedencia(ColegiosEntity tbSchmColegiosByPostProcedencia) {
        this.tbSchmColegiosByPostProcedencia = tbSchmColegiosByPostProcedencia;
    }

    @ManyToOne
    @JoinColumn(name = "POST_Alumno", referencedColumnName = "ALMN_Rut", nullable = false, insertable = false, updatable = false)
    public AlumnoEntity getTbSchpAlumnoByPostAlumno() {
        return tbSchpAlumnoByPostAlumno;
    }

    public void setTbSchpAlumnoByPostAlumno(AlumnoEntity tbSchpAlumnoByPostAlumno) {
        this.tbSchpAlumnoByPostAlumno = tbSchpAlumnoByPostAlumno;
    }

    @ManyToOne
    @JoinColumn(name = "POST_Boleta", referencedColumnName = "BOLE_Id", insertable = false, updatable = false)
    public BoletaServiciosEntity getTbSchpBoletaServiciosByPostBoleta() {
        return tbSchpBoletaServiciosByPostBoleta;
    }

    public void setTbSchpBoletaServiciosByPostBoleta(BoletaServiciosEntity tbSchpBoletaServiciosByPostBoleta) {
        this.tbSchpBoletaServiciosByPostBoleta = tbSchpBoletaServiciosByPostBoleta;
    }
}
