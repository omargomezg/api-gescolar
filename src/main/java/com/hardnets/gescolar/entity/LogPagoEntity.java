package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_LogPago", schema = "dbo", catalog = "kimeltu")
public class LogPagoEntity {
    private int lopaId;
    private String lopaTexto;
    private Timestamp lopaFecha;
    private int lopaBoleta;
    private BoletaServiciosEntity tbSchpBoletaServiciosByLopaBoleta;

    @Id
    @Column(name = "LOPA_Id")
    public int getLopaId() {
        return lopaId;
    }

    public void setLopaId(int lopaId) {
        this.lopaId = lopaId;
    }

    @Basic
    @Column(name = "LOPA_Texto", columnDefinition = "nvarchar(200)")
    public String getLopaTexto() {
        return lopaTexto;
    }

    public void setLopaTexto(String lopaTexto) {
        this.lopaTexto = lopaTexto;
    }

    @Basic
    @Column(name = "LOPA_Fecha")
    public Timestamp getLopaFecha() {
        return lopaFecha;
    }

    public void setLopaFecha(Timestamp lopaFecha) {
        this.lopaFecha = lopaFecha;
    }

    @Basic
    @Column(name = "LOPA_Boleta")
    public int getLopaBoleta() {
        return lopaBoleta;
    }

    public void setLopaBoleta(int lopaBoleta) {
        this.lopaBoleta = lopaBoleta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogPagoEntity that = (LogPagoEntity) o;
        return lopaId == that.lopaId &&
                lopaBoleta == that.lopaBoleta &&
                Objects.equals(lopaTexto, that.lopaTexto) &&
                Objects.equals(lopaFecha, that.lopaFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lopaId, lopaTexto, lopaFecha, lopaBoleta);
    }

    @ManyToOne
    @JoinColumn(name = "LOPA_Boleta", referencedColumnName = "BOLE_Id", nullable = false, insertable = false, updatable = false)
    public BoletaServiciosEntity getTbSchpBoletaServiciosByLopaBoleta() {
        return tbSchpBoletaServiciosByLopaBoleta;
    }

    public void setTbSchpBoletaServiciosByLopaBoleta(BoletaServiciosEntity tbSchpBoletaServiciosByLopaBoleta) {
        this.tbSchpBoletaServiciosByLopaBoleta = tbSchpBoletaServiciosByLopaBoleta;
    }
}
