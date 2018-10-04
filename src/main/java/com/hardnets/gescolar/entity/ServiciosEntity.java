package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Servicios", schema = "dbo", catalog = "kimeltu")
public class ServiciosEntity {
    private byte servId;
    private int servTipo;
    private BigDecimal servMonto;
    private short servAnho;
    private byte servMaxCuotas;
    private String servObservaciones;
    private Collection<DescuentosEntity> tbSchmDescuentosByServId;
    private ParametrosEntity tbSchmParametrosByServTipo;
    private Collection<CompromisoPagoEntity> tbSchpCompromisoPagosByServId;

    @Id
    @Column(name = "SERV_Id")
    public byte getServId() {
        return servId;
    }

    public void setServId(byte servId) {
        this.servId = servId;
    }

    @Basic
    @Column(name = "SERV_Tipo")
    public int getServTipo() {
        return servTipo;
    }

    public void setServTipo(int servTipo) {
        this.servTipo = servTipo;
    }

    @Basic
    @Column(name = "SERV_Monto", columnDefinition = "money)")
    public BigDecimal getServMonto() {
        return servMonto;
    }

    public void setServMonto(BigDecimal servMonto) {
        this.servMonto = servMonto;
    }

    @Basic
    @Column(name = "SERV_Anho")
    public short getServAnho() {
        return servAnho;
    }

    public void setServAnho(short servAnho) {
        this.servAnho = servAnho;
    }

    @Basic
    @Column(name = "SERV_MaxCuotas")
    public byte getServMaxCuotas() {
        return servMaxCuotas;
    }

    public void setServMaxCuotas(byte servMaxCuotas) {
        this.servMaxCuotas = servMaxCuotas;
    }

    @Basic
    @Column(name = "SERV_Observaciones", columnDefinition = "nvarchar(500)")
    public String getServObservaciones() {
        return servObservaciones;
    }

    public void setServObservaciones(String servObservaciones) {
        this.servObservaciones = servObservaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiciosEntity that = (ServiciosEntity) o;
        return servId == that.servId &&
                servTipo == that.servTipo &&
                servAnho == that.servAnho &&
                servMaxCuotas == that.servMaxCuotas &&
                servMonto == that.servMonto &&
                Objects.equals(servObservaciones, that.servObservaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servId, servTipo, servMonto, servAnho, servMaxCuotas, servObservaciones);
    }

    @OneToMany(mappedBy = "tbSchmServiciosByDescServicio")
    public Collection<DescuentosEntity> getTbSchmDescuentosByServId() {
        return tbSchmDescuentosByServId;
    }

    public void setTbSchmDescuentosByServId(Collection<DescuentosEntity> tbSchmDescuentosByServId) {
        this.tbSchmDescuentosByServId = tbSchmDescuentosByServId;
    }

    @ManyToOne
    @JoinColumn(name = "SERV_Tipo", referencedColumnName = "PARA_Id", nullable = false, insertable = false, updatable = false)
    public ParametrosEntity getTbSchmParametrosByServTipo() {
        return tbSchmParametrosByServTipo;
    }

    public void setTbSchmParametrosByServTipo(ParametrosEntity tbSchmParametrosByServTipo) {
        this.tbSchmParametrosByServTipo = tbSchmParametrosByServTipo;
    }

    @OneToMany(mappedBy = "tbSchmServiciosByCompServicio")
    public Collection<CompromisoPagoEntity> getTbSchpCompromisoPagosByServId() {
        return tbSchpCompromisoPagosByServId;
    }

    public void setTbSchpCompromisoPagosByServId(Collection<CompromisoPagoEntity> tbSchpCompromisoPagosByServId) {
        this.tbSchpCompromisoPagosByServId = tbSchpCompromisoPagosByServId;
    }
}
