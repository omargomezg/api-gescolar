package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_DetalleColegiatura", schema = "dbo", catalog = "kimeltu")
public class DetalleColegiaturaEntity {
    private int detcId;
    private int detcColegiatura;
    private Date detcFecha;
    private BigDecimal detcValor;
    private String detcEstado;
    private Integer detcBoleta;
    private ColegiaturaEntity tbSchpColegiaturaByDetcColegiatura;
    private BoletaServiciosEntity tbSchpBoletaServiciosByDetcBoleta;

    @Id
    @Column(name = "DETC_Id")
    public int getDetcId() {
        return detcId;
    }

    public void setDetcId(int detcId) {
        this.detcId = detcId;
    }

    @Basic
    @Column(name = "DETC_Colegiatura")
    public int getDetcColegiatura() {
        return detcColegiatura;
    }

    public void setDetcColegiatura(int detcColegiatura) {
        this.detcColegiatura = detcColegiatura;
    }

    @Basic
    @Column(name = "DETC_Fecha")
    public Date getDetcFecha() {
        return detcFecha;
    }

    public void setDetcFecha(Date detcFecha) {
        this.detcFecha = detcFecha;
    }

    @Basic
    @Column(name = "DETC_Valor")
    public BigDecimal getDetcValor() {
        return detcValor;
    }

    public void setDetcValor(BigDecimal detcValor) {
        this.detcValor = detcValor;
    }

    @Basic
    @Column(name = "DETC_Estado")
    public String getDetcEstado() {
        return detcEstado;
    }

    public void setDetcEstado(String detcEstado) {
        this.detcEstado = detcEstado;
    }

    @Basic
    @Column(name = "DETC_Boleta")
    public Integer getDetcBoleta() {
        return detcBoleta;
    }

    public void setDetcBoleta(Integer detcBoleta) {
        this.detcBoleta = detcBoleta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleColegiaturaEntity that = (DetalleColegiaturaEntity) o;
        return detcId == that.detcId &&
                detcColegiatura == that.detcColegiatura &&
                Objects.equals(detcFecha, that.detcFecha) &&
                detcValor == that.detcValor &&
                Objects.equals(detcEstado, that.detcEstado) &&
                Objects.equals(detcBoleta, that.detcBoleta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detcId, detcColegiatura, detcFecha, detcValor, detcEstado, detcBoleta);
    }

    @ManyToOne
    @JoinColumn(name = "DETC_Colegiatura", referencedColumnName = "COLE_Id", nullable = false, insertable = false, updatable = false)
    public ColegiaturaEntity getTbSchpColegiaturaByDetcColegiatura() {
        return tbSchpColegiaturaByDetcColegiatura;
    }

    public void setTbSchpColegiaturaByDetcColegiatura(ColegiaturaEntity tbSchpColegiaturaByDetcColegiatura) {
        this.tbSchpColegiaturaByDetcColegiatura = tbSchpColegiaturaByDetcColegiatura;
    }

    @ManyToOne
    @JoinColumn(name = "DETC_Boleta", referencedColumnName = "BOLE_Id", insertable = false, updatable = false)
    public BoletaServiciosEntity getTbSchpBoletaServiciosByDetcBoleta() {
        return tbSchpBoletaServiciosByDetcBoleta;
    }

    public void setTbSchpBoletaServiciosByDetcBoleta(BoletaServiciosEntity tbSchpBoletaServiciosByDetcBoleta) {
        this.tbSchpBoletaServiciosByDetcBoleta = tbSchpBoletaServiciosByDetcBoleta;
    }
}
