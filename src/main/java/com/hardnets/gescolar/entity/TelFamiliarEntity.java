package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_TelFamiliar", schema = "dbo", catalog = "kimeltu")
public class TelFamiliarEntity {
    private short id;
    private String familiar;
    private short telefono;
    private FamiliaresEntity tbSchpFamiliaresByFamiliar;
    private TelefonosEntity tbSchpTelefonosByTelefono;

    @Id
    @Column(name = "TELF_Id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TELF_Familiar", insertable = false, updatable = false, columnDefinition = "nvarchar(10)")
    public String getFamiliar() {
        return familiar;
    }

    public void setFamiliar(String familiar) {
        this.familiar = familiar;
    }

    @Basic
    @Column(name = "TELF_Telefono", insertable = false, updatable = false)
    public short getTelefono() {
        return telefono;
    }

    public void setTelefono(short telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelFamiliarEntity that = (TelFamiliarEntity) o;
        return id == that.id &&
                telefono == that.telefono &&
                Objects.equals(familiar, that.familiar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, familiar, telefono);
    }

    @ManyToOne
    @JoinColumn(name = "TELF_Familiar", referencedColumnName = "FAMI_Rut", nullable = false, insertable = false, updatable = false)
    public FamiliaresEntity getTbSchpFamiliaresByFamiliar() {
        return tbSchpFamiliaresByFamiliar;
    }

    public void setTbSchpFamiliaresByFamiliar(FamiliaresEntity tbSchpFamiliaresByFamiliar) {
        this.tbSchpFamiliaresByFamiliar = tbSchpFamiliaresByFamiliar;
    }

    @ManyToOne
    @JoinColumn(name = "TELF_Telefono", referencedColumnName = "TELF_Id", nullable = false, insertable = false, updatable = false)
    public TelefonosEntity getTbSchpTelefonosByTelefono() {
        return tbSchpTelefonosByTelefono;
    }

    public void setTbSchpTelefonosByTelefono(TelefonosEntity tbSchpTelefonosByTelefono) {
        this.tbSchpTelefonosByTelefono = tbSchpTelefonosByTelefono;
    }
}
