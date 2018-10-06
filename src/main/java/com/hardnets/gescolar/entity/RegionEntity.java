package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Region", schema = "dbo")
public class RegionEntity {
    private byte regiId;
    private String regiNombre;
    private Collection<ProvinciaEntity> tbSchpProvinciasByRegiId;

    @Id
    @Column(name = "REGI_Id")
    public byte getRegiId() {
        return regiId;
    }

    public void setRegiId(byte regiId) {
        this.regiId = regiId;
    }

    @Basic
    @Column(name = "REGI_Nombre", columnDefinition = "nvarchar(250)")
    public String getRegiNombre() {
        return regiNombre;
    }

    public void setRegiNombre(String regiNombre) {
        this.regiNombre = regiNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionEntity that = (RegionEntity) o;
        return regiId == that.regiId &&
                Objects.equals(regiNombre, that.regiNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regiId, regiNombre);
    }

    @OneToMany(mappedBy = "tbSchmRegionByProvRegion")
    public Collection<ProvinciaEntity> getTbSchpProvinciasByRegiId() {
        return tbSchpProvinciasByRegiId;
    }

    public void setTbSchpProvinciasByRegiId(Collection<ProvinciaEntity> tbSchpProvinciasByRegiId) {
        this.tbSchpProvinciasByRegiId = tbSchpProvinciasByRegiId;
    }
}
