package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_PlantillaCorreo", schema = "dbo")
public class PlantillaCorreoEntity {
    private byte pcorId;
    private String pcorSubject;
    private String pcorBody;
    private boolean pcorEstado;
    private String pcorParametros;

    @Id
    @Column(name = "PCOR_Id")
    public byte getPcorId() {
        return pcorId;
    }

    public void setPcorId(byte pcorId) {
        this.pcorId = pcorId;
    }

    @Basic
    @Column(name = "PCOR_Subject", columnDefinition = "nvarchar(255)")
    public String getPcorSubject() {
        return pcorSubject;
    }

    public void setPcorSubject(String pcorSubject) {
        this.pcorSubject = pcorSubject;
    }

    @Basic
    @Column(name = "PCOR_Body", columnDefinition = "text")
    public String getPcorBody() {
        return pcorBody;
    }

    public void setPcorBody(String pcorBody) {
        this.pcorBody = pcorBody;
    }

    @Basic
    @Column(name = "PCOR_Estado")
    public boolean isPcorEstado() {
        return pcorEstado;
    }

    public void setPcorEstado(boolean pcorEstado) {
        this.pcorEstado = pcorEstado;
    }

    @Basic
    @Column(name = "PCOR_Parametros", columnDefinition = "nvarchar(200)")
    public String getPcorParametros() {
        return pcorParametros;
    }

    public void setPcorParametros(String pcorParametros) {
        this.pcorParametros = pcorParametros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantillaCorreoEntity that = (PlantillaCorreoEntity) o;
        return pcorId == that.pcorId &&
                pcorEstado == that.pcorEstado &&
                Objects.equals(pcorSubject, that.pcorSubject) &&
                Objects.equals(pcorBody, that.pcorBody) &&
                Objects.equals(pcorParametros, that.pcorParametros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcorId, pcorSubject, pcorBody, pcorEstado, pcorParametros);
    }
}
