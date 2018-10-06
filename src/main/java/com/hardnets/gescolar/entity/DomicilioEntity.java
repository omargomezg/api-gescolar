package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Domicilio", schema = "dbo", catalog = "kimeltu")
public class DomicilioEntity {
    private short domiId;
    private String domiDireccion;
    private String domiNumero;
    private String domiDepartamento;
    private Integer domiComuna;
    private String domiTipo;
    private Collection<AlumnoEntity> tbSchpAlumnosByDomiId;
    private ComunaEntity tbSchpComunaByDomiComuna;

    @Id
    @Column(name = "DOMI_Id")
    public short getDomiId() {
        return domiId;
    }

    public void setDomiId(short domiId) {
        this.domiId = domiId;
    }

    @Basic
    @Column(name = "DOMI_Direccion", columnDefinition = "nvarchar(100)")
    public String getDomiDireccion() {
        return domiDireccion;
    }

    public void setDomiDireccion(String domiDireccion) {
        this.domiDireccion = domiDireccion;
    }

    @Basic
    @Column(name = "DOMI_Numero", columnDefinition = "nvarchar(50)")
    public String getDomiNumero() {
        return domiNumero;
    }

    public void setDomiNumero(String domiNumero) {
        this.domiNumero = domiNumero;
    }

    @Basic
    @Column(name = "DOMI_Departamento", columnDefinition = "nvarchar(50)")
    public String getDomiDepartamento() {
        return domiDepartamento;
    }

    public void setDomiDepartamento(String domiDepartamento) {
        this.domiDepartamento = domiDepartamento;
    }

    @Basic
    @Column(name = "DOMI_Comuna", columnDefinition = "numeric(5,0)")
    public Integer getDomiComuna() {
        return domiComuna;
    }

    public void setDomiComuna(Integer domiComuna) {
        this.domiComuna = domiComuna;
    }

    @Basic
    @Column(name = "DOMI_Tipo", columnDefinition = "char(10)")
    public String getDomiTipo() {
        return domiTipo;
    }

    public void setDomiTipo(String domiTipo) {
        this.domiTipo = domiTipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomicilioEntity that = (DomicilioEntity) o;
        return domiId == that.domiId &&
                Objects.equals(domiDireccion, that.domiDireccion) &&
                Objects.equals(domiNumero, that.domiNumero) &&
                Objects.equals(domiDepartamento, that.domiDepartamento) &&
                Objects.equals(domiComuna, that.domiComuna) &&
                Objects.equals(domiTipo, that.domiTipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domiId, domiDireccion, domiNumero, domiDepartamento, domiComuna, domiTipo);
    }

    @OneToMany(mappedBy = "tbSchpDomicilioByAlmnDomicilio")
    public Collection<AlumnoEntity> getTbSchpAlumnosByDomiId() {
        return tbSchpAlumnosByDomiId;
    }

    public void setTbSchpAlumnosByDomiId(Collection<AlumnoEntity> tbSchpAlumnosByDomiId) {
        this.tbSchpAlumnosByDomiId = tbSchpAlumnosByDomiId;
    }

    @ManyToOne
    @JoinColumn(name = "DOMI_Comuna", referencedColumnName = "COMU_Id", insertable = false, updatable = false)
    public ComunaEntity getTbSchpComunaByDomiComuna() {
        return tbSchpComunaByDomiComuna;
    }

    public void setTbSchpComunaByDomiComuna(ComunaEntity tbSchpComunaByDomiComuna) {
        this.tbSchpComunaByDomiComuna = tbSchpComunaByDomiComuna;
    }
}
