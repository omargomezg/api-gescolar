package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_BoletaCompromisos", schema = "dbo", catalog = "kimeltu")
public class BoletaCompromisosEntity {
    private int bcomId;
    private int bcomCompromisos;
    private int bcomBoleta;
    private CompromisoPagoEntity tbSchpCompromisoPagoByBcomCompromisos;
    private BoletaServiciosEntity tbSchpBoletaServiciosByBcomBoleta;

    @Id
    @Column(name = "BCOM_Id")
    public int getBcomId() {
        return bcomId;
    }

    public void setBcomId(int bcomId) {
        this.bcomId = bcomId;
    }

    @Basic
    @Column(name = "BCOM_Compromisos", insertable = false, updatable = false)
    public int getBcomCompromisos() {
        return bcomCompromisos;
    }

    public void setBcomCompromisos(int bcomCompromisos) {
        this.bcomCompromisos = bcomCompromisos;
    }

    @Basic
    @Column(name = "BCOM_Boleta", insertable = false, updatable = false)
    public int getBcomBoleta() {
        return bcomBoleta;
    }

    public void setBcomBoleta(int bcomBoleta) {
        this.bcomBoleta = bcomBoleta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoletaCompromisosEntity that = (BoletaCompromisosEntity) o;
        return bcomId == that.bcomId &&
                bcomCompromisos == that.bcomCompromisos &&
                bcomBoleta == that.bcomBoleta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bcomId, bcomCompromisos, bcomBoleta);
    }

    @ManyToOne
    @JoinColumn(name = "BCOM_Compromisos", referencedColumnName = "COMP_Id", nullable = false, insertable = false, updatable = false)
    public CompromisoPagoEntity getTbSchpCompromisoPagoByBcomCompromisos() {
        return tbSchpCompromisoPagoByBcomCompromisos;
    }

    public void setTbSchpCompromisoPagoByBcomCompromisos(CompromisoPagoEntity tbSchpCompromisoPagoByBcomCompromisos) {
        this.tbSchpCompromisoPagoByBcomCompromisos = tbSchpCompromisoPagoByBcomCompromisos;
    }

    @ManyToOne
    @JoinColumn(name = "BCOM_Boleta", referencedColumnName = "BOLE_Id", nullable = false, insertable = false, updatable = false)
    public BoletaServiciosEntity getTbSchpBoletaServiciosByBcomBoleta() {
        return tbSchpBoletaServiciosByBcomBoleta;
    }

    public void setTbSchpBoletaServiciosByBcomBoleta(BoletaServiciosEntity tbSchpBoletaServiciosByBcomBoleta) {
        this.tbSchpBoletaServiciosByBcomBoleta = tbSchpBoletaServiciosByBcomBoleta;
    }
}
