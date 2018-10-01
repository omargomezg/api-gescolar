package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_BoletaServicios", schema = "dbo", catalog = "kimeltu")
public class BoletaServiciosEntity {
    private Timestamp boleFecha;
    private Integer boleMonto;
    private int boleDetalleBoleta;
    private int boleId;
    private Integer boleNumeroSii;
    private Boolean boleEstado;
    private String boleComentario;
    private String boleUsuario;
    private Collection<LogPagoEntity> tbSchmLogPagosByBoleId;
    private Collection<BoletaCompromisosEntity> tbSchpBoletaCompromisosByBoleId;
    private DetalleBoletaEntity tbSchpDetalleBoletaByBoleDetalleBoleta;
    private Collection<ColegiaturaEntity> tbSchpColegiaturasByBoleId;
    private Collection<DetalleColegiaturaEntity> tbSchpDetalleColegiaturasByBoleId;
    private Collection<PostulacionEntity> tbSchpPostulacionsByBoleId;

    @Basic
    @Column(name = "BOLE_Fecha")
    public Timestamp getBoleFecha() {
        return boleFecha;
    }

    public void setBoleFecha(Timestamp boleFecha) {
        this.boleFecha = boleFecha;
    }

    @Basic
    @Column(name = "BOLE_Monto", columnDefinition = "numeric(9,0)")
    public Integer getBoleMonto() {
        return boleMonto;
    }

    public void setBoleMonto(Integer boleMonto) {
        this.boleMonto = boleMonto;
    }

    @Basic
    @Column(name = "BOLE_DetalleBoleta")
    public int getBoleDetalleBoleta() {
        return boleDetalleBoleta;
    }

    public void setBoleDetalleBoleta(int boleDetalleBoleta) {
        this.boleDetalleBoleta = boleDetalleBoleta;
    }

    @Id
    @Column(name = "BOLE_Id")
    public int getBoleId() {
        return boleId;
    }

    public void setBoleId(int boleId) {
        this.boleId = boleId;
    }

    @Basic
    @Column(name = "BOLE_NumeroSII", columnDefinition = "numeric(19,0)")
    public Integer getBoleNumeroSii() {
        return boleNumeroSii;
    }

    public void setBoleNumeroSii(Integer boleNumeroSii) {
        this.boleNumeroSii = boleNumeroSii;
    }

    @Basic
    @Column(name = "BOLE_Estado")
    public Boolean getBoleEstado() {
        return boleEstado;
    }

    public void setBoleEstado(Boolean boleEstado) {
        this.boleEstado = boleEstado;
    }

    @Basic
    @Column(name = "BOLE_Comentario", columnDefinition = "nvarchar(255)")
    public String getBoleComentario() {
        return boleComentario;
    }

    public void setBoleComentario(String boleComentario) {
        this.boleComentario = boleComentario;
    }

    @Basic
    @Column(name = "BOLE_Usuario", columnDefinition = "nvarchar(10)")
    public String getBoleUsuario() {
        return boleUsuario;
    }

    public void setBoleUsuario(String boleUsuario) {
        this.boleUsuario = boleUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoletaServiciosEntity that = (BoletaServiciosEntity) o;
        return boleDetalleBoleta == that.boleDetalleBoleta &&
                boleId == that.boleId &&
                Objects.equals(boleFecha, that.boleFecha) &&
                Objects.equals(boleMonto, that.boleMonto) &&
                Objects.equals(boleNumeroSii, that.boleNumeroSii) &&
                Objects.equals(boleEstado, that.boleEstado) &&
                Objects.equals(boleComentario, that.boleComentario) &&
                Objects.equals(boleUsuario, that.boleUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boleFecha, boleMonto, boleDetalleBoleta, boleId, boleNumeroSii, boleEstado, boleComentario, boleUsuario);
    }

    @OneToMany(mappedBy = "tbSchpBoletaServiciosByLopaBoleta")
    public Collection<LogPagoEntity> getTbSchmLogPagosByBoleId() {
        return tbSchmLogPagosByBoleId;
    }

    public void setTbSchmLogPagosByBoleId(Collection<LogPagoEntity> tbSchmLogPagosByBoleId) {
        this.tbSchmLogPagosByBoleId = tbSchmLogPagosByBoleId;
    }

    @OneToMany(mappedBy = "tbSchpBoletaServiciosByBcomBoleta")
    public Collection<BoletaCompromisosEntity> getTbSchpBoletaCompromisosByBoleId() {
        return tbSchpBoletaCompromisosByBoleId;
    }

    public void setTbSchpBoletaCompromisosByBoleId(Collection<BoletaCompromisosEntity> tbSchpBoletaCompromisosByBoleId) {
        this.tbSchpBoletaCompromisosByBoleId = tbSchpBoletaCompromisosByBoleId;
    }

    @ManyToOne
    @JoinColumn(name = "BOLE_DetalleBoleta", referencedColumnName = "TPAG_Id", nullable = false, insertable = false, updatable = false)
    public DetalleBoletaEntity getTbSchpDetalleBoletaByBoleDetalleBoleta() {
        return tbSchpDetalleBoletaByBoleDetalleBoleta;
    }

    public void setTbSchpDetalleBoletaByBoleDetalleBoleta(DetalleBoletaEntity tbSchpDetalleBoletaByBoleDetalleBoleta) {
        this.tbSchpDetalleBoletaByBoleDetalleBoleta = tbSchpDetalleBoletaByBoleDetalleBoleta;
    }

    @OneToMany(mappedBy = "tbSchpBoletaServiciosByColeBoletaMatricula")
    public Collection<ColegiaturaEntity> getTbSchpColegiaturasByBoleId() {
        return tbSchpColegiaturasByBoleId;
    }

    public void setTbSchpColegiaturasByBoleId(Collection<ColegiaturaEntity> tbSchpColegiaturasByBoleId) {
        this.tbSchpColegiaturasByBoleId = tbSchpColegiaturasByBoleId;
    }

    @OneToMany(mappedBy = "tbSchpBoletaServiciosByDetcBoleta")
    public Collection<DetalleColegiaturaEntity> getTbSchpDetalleColegiaturasByBoleId() {
        return tbSchpDetalleColegiaturasByBoleId;
    }

    public void setTbSchpDetalleColegiaturasByBoleId(Collection<DetalleColegiaturaEntity> tbSchpDetalleColegiaturasByBoleId) {
        this.tbSchpDetalleColegiaturasByBoleId = tbSchpDetalleColegiaturasByBoleId;
    }

    @OneToMany(mappedBy = "tbSchpBoletaServiciosByPostBoleta")
    public Collection<PostulacionEntity> getTbSchpPostulacionsByBoleId() {
        return tbSchpPostulacionsByBoleId;
    }

    public void setTbSchpPostulacionsByBoleId(Collection<PostulacionEntity> tbSchpPostulacionsByBoleId) {
        this.tbSchpPostulacionsByBoleId = tbSchpPostulacionsByBoleId;
    }
}
