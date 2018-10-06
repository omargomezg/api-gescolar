package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Comuna", schema = "dbo")
public class ComunaEntity {
    private int comuId;
    private String comuNombre;
    private int comuProvincia;
    private ProvinciaEntity tbSchpProvinciaByComuProvincia;
    private Collection<DomicilioEntity> tbSchpDomiciliosByComuId;

    @Id
    @Column(name = "COMU_Id", columnDefinition = "numeric(5,0)")
    public int getComuId() {
        return comuId;
    }

    public void setComuId(int comuId) {
        this.comuId = comuId;
    }

    @Basic
    @Column(name = "COMU_Nombre", columnDefinition = "nchar(50)")
    public String getComuNombre() {
        return comuNombre;
    }

    public void setComuNombre(String comuNombre) {
        this.comuNombre = comuNombre;
    }

    @Basic
    @Column(name = "COMU_Provincia", insertable = false, updatable = false, columnDefinition = "numeric(3,0)")
    public int getComuProvincia() {
        return comuProvincia;
    }

    public void setComuProvincia(int comuProvincia) {
        this.comuProvincia = comuProvincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComunaEntity that = (ComunaEntity) o;
        return comuId == that.comuId &&
                comuProvincia == that.comuProvincia &&
                Objects.equals(comuNombre, that.comuNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comuId, comuNombre, comuProvincia);
    }

    @ManyToOne
    @JoinColumn(name = "COMU_Provincia", referencedColumnName = "PROV_Id", nullable = false, insertable = false, updatable = false)
    public ProvinciaEntity getTbSchpProvinciaByComuProvincia() {
        return tbSchpProvinciaByComuProvincia;
    }

    public void setTbSchpProvinciaByComuProvincia(ProvinciaEntity tbSchpProvinciaByComuProvincia) {
        this.tbSchpProvinciaByComuProvincia = tbSchpProvinciaByComuProvincia;
    }

    @OneToMany(mappedBy = "tbSchpComunaByDomiComuna")
    public Collection<DomicilioEntity> getTbSchpDomiciliosByComuId() {
        return tbSchpDomiciliosByComuId;
    }

    public void setTbSchpDomiciliosByComuId(Collection<DomicilioEntity> tbSchpDomiciliosByComuId) {
        this.tbSchpDomiciliosByComuId = tbSchpDomiciliosByComuId;
    }
}
