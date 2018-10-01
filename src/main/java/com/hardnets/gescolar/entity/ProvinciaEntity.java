package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Provincia", schema = "dbo", catalog = "kimeltu")
public class ProvinciaEntity {
    private int provId;
    private String provNombre;
    private byte provRegion;
    private Collection<ComunaEntity> tbSchpComunasByProvId;
    private RegionEntity tbSchmRegionByProvRegion;

    @Id
    @Column(name = "PROV_Id", columnDefinition = "numeric(3,0)")
    public int getProvId() {
        return provId;
    }

    public void setProvId(int provId) {
        this.provId = provId;
    }

    @Basic
    @Column(name = "PROV_Nombre", columnDefinition = "nchar(100)")
    public String getProvNombre() {
        return provNombre;
    }

    public void setProvNombre(String provNombre) {
        this.provNombre = provNombre;
    }

    @Basic
    @Column(name = "PROV_Region", insertable = false, updatable = false)
    public byte getProvRegion() {
        return provRegion;
    }

    public void setProvRegion(byte provRegion) {
        this.provRegion = provRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProvinciaEntity that = (ProvinciaEntity) o;
        return provId == that.provId &&
                provRegion == that.provRegion &&
                Objects.equals(provNombre, that.provNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provId, provNombre, provRegion);
    }

    @OneToMany(mappedBy = "tbSchpProvinciaByComuProvincia")
    public Collection<ComunaEntity> getTbSchpComunasByProvId() {
        return tbSchpComunasByProvId;
    }

    public void setTbSchpComunasByProvId(Collection<ComunaEntity> tbSchpComunasByProvId) {
        this.tbSchpComunasByProvId = tbSchpComunasByProvId;
    }

    @ManyToOne
    @JoinColumn(name = "PROV_Region", referencedColumnName = "REGI_Id", nullable = false, insertable = false, updatable = false)
    public RegionEntity getTbSchmRegionByProvRegion() {
        return tbSchmRegionByProvRegion;
    }

    public void setTbSchmRegionByProvRegion(RegionEntity tbSchmRegionByProvRegion) {
        this.tbSchmRegionByProvRegion = tbSchmRegionByProvRegion;
    }
}
