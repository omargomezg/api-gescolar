package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_CompromisoPago", schema = "dbo")
public class CompromisoPagoEntity {
    private int compId;
    private Date compFechaCobro;
    private String compAlumno;
    private String compConcepto;
    private int compValor;
    private String compTipo;
    private String compEstado;
    private Date compFechaIngreso;
    private Byte compServicio;
    private String compDetalle;
    private Integer compValorFinal;
    private Collection<BoletaCompromisosEntity> tbSchpBoletaCompromisosByCompId;
    private AlumnoEntity tbSchpAlumnoByCompAlumno;
    private ServiciosEntity tbSchmServiciosByCompServicio;

    @Id
    @Column(name = "COMP_Id")
    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }

    @Basic
    @Column(name = "COMP_FechaCobro")
    public Date getCompFechaCobro() {
        return compFechaCobro;
    }

    public void setCompFechaCobro(Date compFechaCobro) {
        this.compFechaCobro = compFechaCobro;
    }

    @Basic
    @Column(name = "COMP_Alumno", insertable = false, updatable = false, columnDefinition = "nvarchar(10)")
    public String getCompAlumno() {
        return compAlumno;
    }

    public void setCompAlumno(String compAlumno) {
        this.compAlumno = compAlumno;
    }

    @Basic
    @Column(name = "COMP_Concepto", columnDefinition = "char(2)")
    public String getCompConcepto() {
        return compConcepto;
    }

    public void setCompConcepto(String compConcepto) {
        this.compConcepto = compConcepto;
    }

    @Basic
    @Column(name = "COMP_Valor", columnDefinition = "numeric(9,0)")
    public int getCompValor() {
        return compValor;
    }

    public void setCompValor(int compValor) {
        this.compValor = compValor;
    }

    @Basic
    @Column(name = "COMP_Tipo", columnDefinition = "nchar(10)")
    public String getCompTipo() {
        return compTipo;
    }

    public void setCompTipo(String compTipo) {
        this.compTipo = compTipo;
    }

    @Basic
    @Column(name = "COMP_Estado", columnDefinition = "char(10)")
    public String getCompEstado() {
        return compEstado;
    }

    public void setCompEstado(String compEstado) {
        this.compEstado = compEstado;
    }

    @Basic
    @Column(name = "COMP_FechaIngreso")
    public Date getCompFechaIngreso() {
        return compFechaIngreso;
    }

    public void setCompFechaIngreso(Date compFechaIngreso) {
        this.compFechaIngreso = compFechaIngreso;
    }

    @Basic
    @Column(name = "COMP_Servicio", insertable = false, updatable = false)
    public Byte getCompServicio() {
        return compServicio;
    }

    public void setCompServicio(Byte compServicio) {
        this.compServicio = compServicio;
    }

    @Basic
    @Column(name = "COMP_Detalle", columnDefinition = "nvarchar(200)")
    public String getCompDetalle() {
        return compDetalle;
    }

    public void setCompDetalle(String compDetalle) {
        this.compDetalle = compDetalle;
    }

    @Basic
    @Column(name = "COMP_ValorFinal", columnDefinition = "numeric(9,0)")
    public Integer getCompValorFinal() {
        return compValorFinal;
    }

    public void setCompValorFinal(Integer compValorFinal) {
        this.compValorFinal = compValorFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompromisoPagoEntity that = (CompromisoPagoEntity) o;
        return compId == that.compId &&
                compValor == that.compValor &&
                Objects.equals(compFechaCobro, that.compFechaCobro) &&
                Objects.equals(compAlumno, that.compAlumno) &&
                Objects.equals(compConcepto, that.compConcepto) &&
                Objects.equals(compTipo, that.compTipo) &&
                Objects.equals(compEstado, that.compEstado) &&
                Objects.equals(compFechaIngreso, that.compFechaIngreso) &&
                Objects.equals(compServicio, that.compServicio) &&
                Objects.equals(compDetalle, that.compDetalle) &&
                Objects.equals(compValorFinal, that.compValorFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compId, compFechaCobro, compAlumno, compConcepto, compValor, compTipo, compEstado, compFechaIngreso, compServicio, compDetalle, compValorFinal);
    }

    @OneToMany(mappedBy = "tbSchpCompromisoPagoByBcomCompromisos")
    public Collection<BoletaCompromisosEntity> getTbSchpBoletaCompromisosByCompId() {
        return tbSchpBoletaCompromisosByCompId;
    }

    public void setTbSchpBoletaCompromisosByCompId(Collection<BoletaCompromisosEntity> tbSchpBoletaCompromisosByCompId) {
        this.tbSchpBoletaCompromisosByCompId = tbSchpBoletaCompromisosByCompId;
    }

    @ManyToOne
    @JoinColumn(name = "COMP_Alumno", referencedColumnName = "ALMN_Rut", nullable = false, insertable = false, updatable = false)
    public AlumnoEntity getTbSchpAlumnoByCompAlumno() {
        return tbSchpAlumnoByCompAlumno;
    }

    public void setTbSchpAlumnoByCompAlumno(AlumnoEntity tbSchpAlumnoByCompAlumno) {
        this.tbSchpAlumnoByCompAlumno = tbSchpAlumnoByCompAlumno;
    }

    @ManyToOne
    @JoinColumn(name = "COMP_Servicio", referencedColumnName = "SERV_Id", insertable = false, updatable = false)
    public ServiciosEntity getTbSchmServiciosByCompServicio() {
        return tbSchmServiciosByCompServicio;
    }

    public void setTbSchmServiciosByCompServicio(ServiciosEntity tbSchmServiciosByCompServicio) {
        this.tbSchmServiciosByCompServicio = tbSchmServiciosByCompServicio;
    }
}
