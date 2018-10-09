package com.hardnets.gescolar.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Parametros", schema = "dbo")
@Getter
@Setter
public class ParametrosEntity {
    @Id
    @Column(name = "PARA_Id", columnDefinition = "int")
    private Long paraId;
    @Basic
    @Column(name = "PARA_Grupo")
    private short idGrupo;
    @Basic
    @Column(name = "PARA_Detalle")
    private short idDetalle;
    @Basic
    @Column(name = "PARA_Descripcion", columnDefinition = "nvarchar(200)")
    private String paraDescripcion;
    @Basic
    @Column(name = "PARA_Estado")
    private Boolean paraEstado;
    @OneToMany(mappedBy = "tbSchmParametrosByServTipo")
    private Collection<ServiciosEntity> tbSchmServiciosByParaId;
    @OneToMany(mappedBy = "tbSchmParametrosByFamiEstadoCivil")
    private Collection<FamiliaresEntity> tbSchpFamiliaresByParaId;
    @OneToMany(mappedBy = "tbSchmParametrosByFamiParentesco")
    private Collection<FamiliaresEntity> tbSchpFamiliaresByParaId_0;

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
}
