package com.hardnets.gescolar.entity;


import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_SCHP_Familiares", schema = "dbo")
@Getter
@Setter
/* @EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)*/
@SuppressWarnings("serial")
public class FamiliaresEntity implements Serializable {
    
    @Id
    @Column(name = "FAMI_Rut", columnDefinition = "nvarchar(10)")
    private String rut;
    @Basic
    @Column(name = "FAMI_Nombres", columnDefinition = "varchar(255)")
    private String nombres;
    @Basic
    @Column(name = "FAMI_ApPaterno", columnDefinition = "varchar(255)")
    private String apellidoPaterno;
    @Basic
    @Column(name = "FAMI_ApMaterno", columnDefinition = "varchar(255)")
    private String apellidoMaterno;
    @Basic
    @Column(name = "FAMI_Nacimiento")
    private Date fechaNacimiento;
    @Basic
    @Column(name = "FAMI_EstadoCivil")
    private Integer estadoCivil;
    @Basic
    @Column(name = "FAMI_Correo", columnDefinition = "varchar(200)")
    private String correo;
    @Basic
    @Column(name = "FAMI_Genero", columnDefinition = "nchar(1)")
    private String Genero;
    @Basic
    @Column(name = "FAMI_GrupoFamiliar")
    private Integer GrupoFamiliar;
    @Basic
    @Column(name = "FAMI_Parentesco")
    private Integer parentesco;
    @Basic
    @Column(name = "FAMI_Profesion", columnDefinition = "nvarchar(100)")
    private String profesion;
    @Basic
    @Column(name = "FAMI_Fijo", columnDefinition = "nvarchar(15)")
    private String telefonoFijo;
    @Basic
    @Column(name = "FAMI_Movil", columnDefinition = "nvarchar(15)")
    private String telefonoMovil;
    @OneToMany(mappedBy = "tbSchpFamiliaresByAlmnApoderado")
    private Collection<AlumnoEntity> tbSchpAlumnosByFamiRut;
    @ManyToOne
    @JoinColumn(name = "FAMI_EstadoCivil", referencedColumnName = "PARA_Id", insertable = false, updatable = false)
    private ParametrosEntity tbSchmParametrosByFamiEstadoCivil;
    @ManyToOne
    @JoinColumn(name = "FAMI_GrupoFamiliar", referencedColumnName = "GFAM_Id", insertable = false, updatable = false)
    private GrupoFamiliarEntity tbSchpGrupoFamiliarByFamiGrupoFamiliar;
    @ManyToOne
    @JoinColumn(name = "FAMI_Parentesco", referencedColumnName = "PARA_Id", insertable = false, updatable = false)
    private ParametrosEntity tbSchmParametrosByFamiParentesco;
    @OneToMany(mappedBy = "tbSchpFamiliaresByFamiliar")
    private Collection<TelFamiliarEntity> tbSchpTelFamiliarsByFamiRut;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamiliaresEntity that = (FamiliaresEntity) o;
        return Objects.equals(rut, that.rut) &&
                Objects.equals(nombres, that.nombres) &&
                Objects.equals(apellidoPaterno, that.apellidoPaterno) &&
                Objects.equals(apellidoMaterno, that.apellidoMaterno) &&
                Objects.equals(fechaNacimiento, that.fechaNacimiento) &&
                Objects.equals(estadoCivil, that.estadoCivil) &&
                Objects.equals(correo, that.correo) &&
                Objects.equals(Genero, that.Genero) &&
                Objects.equals(GrupoFamiliar, that.GrupoFamiliar) &&
                Objects.equals(parentesco, that.parentesco) &&
                Objects.equals(profesion, that.profesion) &&
                Objects.equals(telefonoFijo, that.telefonoFijo) &&
                Objects.equals(telefonoMovil, that.telefonoMovil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rut, nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, estadoCivil, correo,
                Genero, GrupoFamiliar, parentesco, profesion, telefonoFijo, telefonoMovil);
    }   
   
}
