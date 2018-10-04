package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Parametros", schema = "dbo", catalog = "kimeltu")
public class ParametrosEntity {
    private Long paraId;
    private short idGrupo;
    private short idDetalle;
    private String paraDescripcion;
    private Boolean paraEstado;
    private Collection<ServiciosEntity> tbSchmServiciosByParaId;
    private Collection<FamiliaresEntity> tbSchpFamiliaresByParaId;
    private Collection<FamiliaresEntity> tbSchpFamiliaresByParaId_0;

    @Id
    @Column(name = "PARA_Id", columnDefinition = "int")
    public Long getParaId() {
        return paraId;
    }

    public void setParaId(Long paraId) {
        this.paraId = paraId;
    }

    @Basic
    @Column(name = "PARA_Grupo")
    public short getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(short idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Basic
    @Column(name = "PARA_Detalle")
    public short getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(short idDetalle) {
        this.idDetalle = idDetalle;
    }

    @Basic
    @Column(name = "PARA_Descripcion", columnDefinition = "nvarchar(200)")
    public String getParaDescripcion() {
        return paraDescripcion;
    }

    public void setParaDescripcion(String paraDescripcion) {
        this.paraDescripcion = paraDescripcion;
    }

    @Basic
    @Column(name = "PARA_Estado")
    public Boolean getParaEstado() {
        return paraEstado;
    }

    public void setParaEstado(Boolean paraEstado) {
        this.paraEstado = paraEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParametrosEntity that = (ParametrosEntity) o;
        return paraId == that.paraId &&
                idGrupo == that.idGrupo &&
                idDetalle == that.idDetalle &&
                Objects.equals(paraDescripcion, that.paraDescripcion) &&
                Objects.equals(paraEstado, that.paraEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paraId, idGrupo, idDetalle, paraDescripcion, paraEstado);
    }

    @OneToMany(mappedBy = "tbSchmParametrosByServTipo")
    public Collection<ServiciosEntity> getTbSchmServiciosByParaId() {
        return tbSchmServiciosByParaId;
    }

    public void setTbSchmServiciosByParaId(Collection<ServiciosEntity> tbSchmServiciosByParaId) {
        this.tbSchmServiciosByParaId = tbSchmServiciosByParaId;
    }

    @OneToMany(mappedBy = "tbSchmParametrosByFamiEstadoCivil")
    public Collection<FamiliaresEntity> getTbSchpFamiliaresByParaId() {
        return tbSchpFamiliaresByParaId;
    }

    public void setTbSchpFamiliaresByParaId(Collection<FamiliaresEntity> tbSchpFamiliaresByParaId) {
        this.tbSchpFamiliaresByParaId = tbSchpFamiliaresByParaId;
    }

    @OneToMany(mappedBy = "tbSchmParametrosByFamiParentesco")
    public Collection<FamiliaresEntity> getTbSchpFamiliaresByParaId_0() {
        return tbSchpFamiliaresByParaId_0;
    }

    public void setTbSchpFamiliaresByParaId_0(Collection<FamiliaresEntity> tbSchpFamiliaresByParaId_0) {
        this.tbSchpFamiliaresByParaId_0 = tbSchpFamiliaresByParaId_0;
    }
}
