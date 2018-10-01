package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Errores", schema = "dbo", catalog = "kimeltu")
public class ErroresEntity {
    private String errorId;
    private String erroDetalle;
    private Timestamp erroFecha;
    private String erroTipo;
    private String erroOrigen;

    @Id
    @Column(name = "ERROR_Id", columnDefinition = "uniqueidentifier")
    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    @Basic
    @Column(name = "ERRO_Detalle", columnDefinition = "nvarchar(100)")
    public String getErroDetalle() {
        return erroDetalle;
    }

    public void setErroDetalle(String erroDetalle) {
        this.erroDetalle = erroDetalle;
    }

    @Basic
    @Column(name = "ERRO_Fecha")
    public Timestamp getErroFecha() {
        return erroFecha;
    }

    public void setErroFecha(Timestamp erroFecha) {
        this.erroFecha = erroFecha;
    }

    @Basic
    @Column(name = "ERRO_Tipo")
    public String getErroTipo() {
        return erroTipo;
    }

    public void setErroTipo(String erroTipo) {
        this.erroTipo = erroTipo;
    }

    @Basic
    @Column(name = "ERRO_Origen", columnDefinition = "text")
    public String getErroOrigen() {
        return erroOrigen;
    }

    public void setErroOrigen(String erroOrigen) {
        this.erroOrigen = erroOrigen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErroresEntity that = (ErroresEntity) o;
        return  errorId == that.errorId &&
                Objects.equals(erroDetalle, that.erroDetalle) &&
                Objects.equals(erroFecha, that.erroFecha) &&
                Objects.equals(erroTipo, that.erroTipo) &&
                Objects.equals(erroOrigen, that.erroOrigen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorId, erroDetalle, erroFecha, erroTipo, erroOrigen);
    }
}
