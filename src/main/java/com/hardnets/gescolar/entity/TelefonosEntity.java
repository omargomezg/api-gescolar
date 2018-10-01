package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Telefonos", schema = "dbo", catalog = "kimeltu")
public class TelefonosEntity {
    private short telfId;
    private String telfNumero;
    private String telfTipo;
    private Collection<TelFamiliarEntity> tbSchpTelFamiliarsByTelfId;

    @Id
    @Column(name = "TELF_Id")
    public short getTelfId() {
        return telfId;
    }

    public void setTelfId(short telfId) {
        this.telfId = telfId;
    }

    @Basic
    @Column(name = "TELF_Numero", columnDefinition = "nvarchar(15)")
    public String getTelfNumero() {
        return telfNumero;
    }

    public void setTelfNumero(String telfNumero) {
        this.telfNumero = telfNumero;
    }

    @Basic
    @Column(name = "TELF_Tipo", columnDefinition = "nvarchar(50)")
    public String getTelfTipo() {
        return telfTipo;
    }

    public void setTelfTipo(String telfTipo) {
        this.telfTipo = telfTipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonosEntity that = (TelefonosEntity) o;
        return telfId == that.telfId &&
                Objects.equals(telfNumero, that.telfNumero) &&
                Objects.equals(telfTipo, that.telfTipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telfId, telfNumero, telfTipo);
    }

    @OneToMany(mappedBy = "tbSchpTelefonosByTelfTelefono")
    public Collection<TelFamiliarEntity> getTbSchpTelFamiliarsByTelfId() {
        return tbSchpTelFamiliarsByTelfId;
    }

    public void setTbSchpTelFamiliarsByTelfId(Collection<TelFamiliarEntity> tbSchpTelFamiliarsByTelfId) {
        this.tbSchpTelFamiliarsByTelfId = tbSchpTelFamiliarsByTelfId;
    }
}
