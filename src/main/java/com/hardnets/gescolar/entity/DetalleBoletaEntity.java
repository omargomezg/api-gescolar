package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_DetalleBoleta", schema = "dbo")
public class DetalleBoletaEntity {
    private int tpagId;
    private byte tpagTipo;
    private String tpagNumero;
    private Date tpagFecha;
    private String tpagBanco;
    private String tpagEstado;
    private Boolean tpagEstadoCobroCheque;
    private Collection<BoletaServiciosEntity> tbSchpBoletaServiciosByTpagId;

    @Id
    @Column(name = "TPAG_Id")
    public int getTpagId() {
        return tpagId;
    }

    public void setTpagId(int tpagId) {
        this.tpagId = tpagId;
    }

    @Basic
    @Column(name = "TPAG_Tipo")
    public byte getTpagTipo() {
        return tpagTipo;
    }

    public void setTpagTipo(byte tpagTipo) {
        this.tpagTipo = tpagTipo;
    }

    @Basic
    @Column(name = "TPAG_Numero", columnDefinition = "nvarchar(50)")
    public String getTpagNumero() {
        return tpagNumero;
    }

    public void setTpagNumero(String tpagNumero) {
        this.tpagNumero = tpagNumero;
    }

    @Basic
    @Column(name = "TPAG_Fecha")
    public Date getTpagFecha() {
        return tpagFecha;
    }

    public void setTpagFecha(Date tpagFecha) {
        this.tpagFecha = tpagFecha;
    }

    @Basic
    @Column(name = "TPAG_Banco", columnDefinition = "nvarchar(255)")
    public String getTpagBanco() {
        return tpagBanco;
    }

    public void setTpagBanco(String tpagBanco) {
        this.tpagBanco = tpagBanco;
    }

    @Basic
    @Column(name = "TPAG_Estado", columnDefinition = "varchar(9)")
    public String getTpagEstado() {
        return tpagEstado;
    }

    public void setTpagEstado(String tpagEstado) {
        this.tpagEstado = tpagEstado;
    }

    @Basic
    @Column(name = "TPAG_EstadoCobroCheque")
    public Boolean getTpagEstadoCobroCheque() {
        return tpagEstadoCobroCheque;
    }

    public void setTpagEstadoCobroCheque(Boolean tpagEstadoCobroCheque) {
        this.tpagEstadoCobroCheque = tpagEstadoCobroCheque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleBoletaEntity that = (DetalleBoletaEntity) o;
        return tpagId == that.tpagId &&
                tpagTipo == that.tpagTipo &&
                Objects.equals(tpagNumero, that.tpagNumero) &&
                Objects.equals(tpagFecha, that.tpagFecha) &&
                Objects.equals(tpagBanco, that.tpagBanco) &&
                Objects.equals(tpagEstado, that.tpagEstado) &&
                Objects.equals(tpagEstadoCobroCheque, that.tpagEstadoCobroCheque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tpagId, tpagTipo, tpagNumero, tpagFecha, tpagBanco, tpagEstado, tpagEstadoCobroCheque);
    }

    @OneToMany(mappedBy = "tbSchpDetalleBoletaByBoleDetalleBoleta")
    public Collection<BoletaServiciosEntity> getTbSchpBoletaServiciosByTpagId() {
        return tbSchpBoletaServiciosByTpagId;
    }

    public void setTbSchpBoletaServiciosByTpagId(Collection<BoletaServiciosEntity> tbSchpBoletaServiciosByTpagId) {
        this.tbSchpBoletaServiciosByTpagId = tbSchpBoletaServiciosByTpagId;
    }
}
