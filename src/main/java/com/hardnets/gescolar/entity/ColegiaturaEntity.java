package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Colegiatura", schema = "dbo")
public class ColegiaturaEntity {
    private int coleId;
    private String coleAlumno;
    private String coleEstado;
    private int coleBoletaMatricula;
    private AlumnoEntity tbSchpAlumnoByColeAlumno;
    private BoletaServiciosEntity tbSchpBoletaServiciosByColeBoletaMatricula;
    private Collection<DetalleColegiaturaEntity> tbSchpDetalleColegiaturasByColeId;

    @Id
    @Column(name = "COLE_Id")
    public int getColeId() {
        return coleId;
    }

    public void setColeId(int coleId) {
        this.coleId = coleId;
    }

    @Basic
    @Column(name = "COLE_Alumno", columnDefinition = "nvarchar(10)")
    public String getColeAlumno() {
        return coleAlumno;
    }

    public void setColeAlumno(String coleAlumno) {
        this.coleAlumno = coleAlumno;
    }

    @Basic
    @Column(name = "COLE_Estado", columnDefinition = "char(10)")
    public String getColeEstado() {
        return coleEstado;
    }

    public void setColeEstado(String coleEstado) {
        this.coleEstado = coleEstado;
    }

    @Basic
    @Column(name = "COLE_BoletaMatricula")
    public int getColeBoletaMatricula() {
        return coleBoletaMatricula;
    }

    public void setColeBoletaMatricula(int coleBoletaMatricula) {
        this.coleBoletaMatricula = coleBoletaMatricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColegiaturaEntity that = (ColegiaturaEntity) o;
        return coleId == that.coleId &&
                coleBoletaMatricula == that.coleBoletaMatricula &&
                Objects.equals(coleAlumno, that.coleAlumno) &&
                Objects.equals(coleEstado, that.coleEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coleId, coleAlumno, coleEstado, coleBoletaMatricula);
    }

    @ManyToOne
    @JoinColumn(name = "COLE_Alumno", referencedColumnName = "ALMN_Rut", nullable = false, insertable = false, updatable = false)
    public AlumnoEntity getTbSchpAlumnoByColeAlumno() {
        return tbSchpAlumnoByColeAlumno;
    }

    public void setTbSchpAlumnoByColeAlumno(AlumnoEntity tbSchpAlumnoByColeAlumno) {
        this.tbSchpAlumnoByColeAlumno = tbSchpAlumnoByColeAlumno;
    }

    @ManyToOne
    @JoinColumn(name = "COLE_BoletaMatricula", referencedColumnName = "BOLE_Id", nullable = false, insertable = false, updatable = false)
    public BoletaServiciosEntity getTbSchpBoletaServiciosByColeBoletaMatricula() {
        return tbSchpBoletaServiciosByColeBoletaMatricula;
    }

    public void setTbSchpBoletaServiciosByColeBoletaMatricula(BoletaServiciosEntity tbSchpBoletaServiciosByColeBoletaMatricula) {
        this.tbSchpBoletaServiciosByColeBoletaMatricula = tbSchpBoletaServiciosByColeBoletaMatricula;
    }

    @OneToMany(mappedBy = "tbSchpColegiaturaByDetcColegiatura")
    public Collection<DetalleColegiaturaEntity> getTbSchpDetalleColegiaturasByColeId() {
        return tbSchpDetalleColegiaturasByColeId;
    }

    public void setTbSchpDetalleColegiaturasByColeId(Collection<DetalleColegiaturaEntity> tbSchpDetalleColegiaturasByColeId) {
        this.tbSchpDetalleColegiaturasByColeId = tbSchpDetalleColegiaturasByColeId;
    }
}
