package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Telefonos", schema = "dbo", catalog = "kimeltu")
public class TelefonosEntity {
    private short id;
    private String numero;
    private String tipo;
    private Collection<TelFamiliarEntity> tbSchpTelFamiliarsById;

    @Id
    @Column(name = "TELF_Id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TELF_Numero", columnDefinition = "nvarchar(15)")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "TELF_Tipo", columnDefinition = "nvarchar(50)")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonosEntity that = (TelefonosEntity) o;
        return id == that.id &&
                Objects.equals(numero, that.numero) &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, tipo);
    }

    @OneToMany(mappedBy = "tbSchpTelefonosByTelefono")
    public Collection<TelFamiliarEntity> getTbSchpTelFamiliarsById() {
        return tbSchpTelFamiliarsById;
    }

    public void setTbSchpTelFamiliarsById(Collection<TelFamiliarEntity> tbSchpTelFamiliarsById) {
        this.tbSchpTelFamiliarsById = tbSchpTelFamiliarsById;
    }
}
