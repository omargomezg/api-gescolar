package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_TelFamiliar", schema = "dbo", catalog = "kimeltu")
public class TelFamiliarEntity {
    private short telfId;
    private String telfFamiliar;
    private short telfTelefono;
    private FamiliaresEntity tbSchpFamiliaresByTelfFamiliar;
    private TelefonosEntity tbSchpTelefonosByTelfTelefono;

    @Id
    @Column(name = "TELF_Id")
    public short getTelfId() {
        return telfId;
    }

    public void setTelfId(short telfId) {
        this.telfId = telfId;
    }

    @Basic
    @Column(name = "TELF_Familiar", insertable = false, updatable = false)
    public String getTelfFamiliar() {
        return telfFamiliar;
    }

    public void setTelfFamiliar(String telfFamiliar) {
        this.telfFamiliar = telfFamiliar;
    }

    @Basic
    @Column(name = "TELF_Telefono", insertable = false, updatable = false)
    public short getTelfTelefono() {
        return telfTelefono;
    }

    public void setTelfTelefono(short telfTelefono) {
        this.telfTelefono = telfTelefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelFamiliarEntity that = (TelFamiliarEntity) o;
        return telfId == that.telfId &&
                telfTelefono == that.telfTelefono &&
                Objects.equals(telfFamiliar, that.telfFamiliar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telfId, telfFamiliar, telfTelefono);
    }

    @ManyToOne
    @JoinColumn(name = "TELF_Familiar", referencedColumnName = "FAMI_Rut", nullable = false, insertable = false, updatable = false)
    public FamiliaresEntity getTbSchpFamiliaresByTelfFamiliar() {
        return tbSchpFamiliaresByTelfFamiliar;
    }

    public void setTbSchpFamiliaresByTelfFamiliar(FamiliaresEntity tbSchpFamiliaresByTelfFamiliar) {
        this.tbSchpFamiliaresByTelfFamiliar = tbSchpFamiliaresByTelfFamiliar;
    }

    @ManyToOne
    @JoinColumn(name = "TELF_Telefono", referencedColumnName = "TELF_Id", nullable = false, insertable = false, updatable = false)
    public TelefonosEntity getTbSchpTelefonosByTelfTelefono() {
        return tbSchpTelefonosByTelfTelefono;
    }

    public void setTbSchpTelefonosByTelfTelefono(TelefonosEntity tbSchpTelefonosByTelfTelefono) {
        this.tbSchpTelefonosByTelfTelefono = tbSchpTelefonosByTelfTelefono;
    }
}
