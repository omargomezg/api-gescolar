package com.hardnets.gescolar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Familiares", schema = "dbo", catalog = "kimeltu")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public class FamiliaresEntity implements Serializable {
    private String Rut;
    private String famiNombres;
    private String famiApPaterno;
    private String famiApMaterno;
    private Date famiNacimiento;
    private Integer famiEstadoCivil;
    private String famiCorreo;
    private String famiGenero;
    private Integer famiGrupoFamiliar;
    private Integer famiParentesco;
    private String famiProfesion;
    private String famiFijo;
    private String famiMovil;
    private Collection<AlumnoEntity> tbSchpAlumnosByFamiRut;
    private ParametrosEntity tbSchmParametrosByFamiEstadoCivil;
    private GrupoFamiliarEntity tbSchpGrupoFamiliarByFamiGrupoFamiliar;
    private ParametrosEntity tbSchmParametrosByFamiParentesco;
    private Collection<TelFamiliarEntity> tbSchpTelFamiliarsByFamiRut;

    @Id
    @Column(name = "FAMI_Rut", columnDefinition = "nvarchar(10)")
    public String getFamiRut() {
        return Rut;
    }

    public void setFamiRut(String Rut) {
        this.Rut = Rut;
    }

    @Basic
    @Column(name = "FAMI_Nombres", columnDefinition = "varchar(255)")
    public String getFamiNombres() {
        return famiNombres;
    }

    public void setFamiNombres(String famiNombres) {
        this.famiNombres = famiNombres;
    }

    @Basic
    @Column(name = "FAMI_ApPaterno", columnDefinition = "varchar(255)")
    public String getFamiApPaterno() {
        return famiApPaterno;
    }

    public void setFamiApPaterno(String famiApPaterno) {
        this.famiApPaterno = famiApPaterno;
    }

    @Basic
    @Column(name = "FAMI_ApMaterno", columnDefinition = "varchar(255)")
    public String getFamiApMaterno() {
        return famiApMaterno;
    }

    public void setFamiApMaterno(String famiApMaterno) {
        this.famiApMaterno = famiApMaterno;
    }

    @Basic
    @Column(name = "FAMI_Nacimiento")
    public Date getFamiNacimiento() {
        return famiNacimiento;
    }

    public void setFamiNacimiento(Date famiNacimiento) {
        this.famiNacimiento = famiNacimiento;
    }

    @Basic
    @Column(name = "FAMI_EstadoCivil")
    public Integer getFamiEstadoCivil() {
        return famiEstadoCivil;
    }

    public void setFamiEstadoCivil(Integer famiEstadoCivil) {
        this.famiEstadoCivil = famiEstadoCivil;
    }

    @Basic
    @Column(name = "FAMI_Correo", columnDefinition = "varchar(200)")
    public String getFamiCorreo() {
        return famiCorreo;
    }

    public void setFamiCorreo(String famiCorreo) {
        this.famiCorreo = famiCorreo;
    }

    @Basic
    @Column(name = "FAMI_Genero", columnDefinition = "nchar(1)")
    public String getFamiGenero() {
        return famiGenero;
    }

    public void setFamiGenero(String famiGenero) {
        this.famiGenero = famiGenero;
    }

    @Basic
    @Column(name = "FAMI_GrupoFamiliar")
    public Integer getFamiGrupoFamiliar() {
        return famiGrupoFamiliar;
    }

    public void setFamiGrupoFamiliar(Integer famiGrupoFamiliar) {
        this.famiGrupoFamiliar = famiGrupoFamiliar;
    }

    @Basic
    @Column(name = "FAMI_Parentesco")
    public Integer getFamiParentesco() {
        return famiParentesco;
    }

    public void setFamiParentesco(Integer famiParentesco) {
        this.famiParentesco = famiParentesco;
    }

    @Basic
    @Column(name = "FAMI_Profesion", columnDefinition = "nvarchar(100)")
    public String getFamiProfesion() {
        return famiProfesion;
    }

    public void setFamiProfesion(String famiProfesion) {
        this.famiProfesion = famiProfesion;
    }

    @Basic
    @Column(name = "FAMI_Fijo", columnDefinition = "nvarchar(15)")
    public String getFamiFijo() {
        return famiFijo;
    }

    public void setFamiFijo(String famiFijo) {
        this.famiFijo = famiFijo;
    }

    @Basic
    @Column(name = "FAMI_Movil", columnDefinition = "nvarchar(15)")
    public String getFamiMovil() {
        return famiMovil;
    }

    public void setFamiMovil(String famiMovil) {
        this.famiMovil = famiMovil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamiliaresEntity that = (FamiliaresEntity) o;
        return Objects.equals(Rut, that.Rut) &&
                Objects.equals(famiNombres, that.famiNombres) &&
                Objects.equals(famiApPaterno, that.famiApPaterno) &&
                Objects.equals(famiApMaterno, that.famiApMaterno) &&
                Objects.equals(famiNacimiento, that.famiNacimiento) &&
                Objects.equals(famiEstadoCivil, that.famiEstadoCivil) &&
                Objects.equals(famiCorreo, that.famiCorreo) &&
                Objects.equals(famiGenero, that.famiGenero) &&
                Objects.equals(famiGrupoFamiliar, that.famiGrupoFamiliar) &&
                Objects.equals(famiParentesco, that.famiParentesco) &&
                Objects.equals(famiProfesion, that.famiProfesion) &&
                Objects.equals(famiFijo, that.famiFijo) &&
                Objects.equals(famiMovil, that.famiMovil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Rut, famiNombres, famiApPaterno, famiApMaterno, famiNacimiento, famiEstadoCivil, famiCorreo, famiGenero, famiGrupoFamiliar, famiParentesco, famiProfesion, famiFijo, famiMovil);
    }

    @OneToMany(mappedBy = "tbSchpFamiliaresByAlmnApoderado")
    public Collection<AlumnoEntity> getTbSchpAlumnosByFamiRut() {
        return tbSchpAlumnosByFamiRut;
    }

    public void setTbSchpAlumnosByFamiRut(Collection<AlumnoEntity> tbSchpAlumnosByFamiRut) {
        this.tbSchpAlumnosByFamiRut = tbSchpAlumnosByFamiRut;
    }

    @ManyToOne
    @JoinColumn(name = "FAMI_EstadoCivil", referencedColumnName = "PARA_Id", insertable = false, updatable = false)
    public ParametrosEntity getTbSchmParametrosByFamiEstadoCivil() {
        return tbSchmParametrosByFamiEstadoCivil;
    }

    public void setTbSchmParametrosByFamiEstadoCivil(ParametrosEntity tbSchmParametrosByFamiEstadoCivil) {
        this.tbSchmParametrosByFamiEstadoCivil = tbSchmParametrosByFamiEstadoCivil;
    }

    @ManyToOne
    @JoinColumn(name = "FAMI_GrupoFamiliar", referencedColumnName = "GFAM_Id", insertable = false, updatable = false)
    public GrupoFamiliarEntity getTbSchpGrupoFamiliarByFamiGrupoFamiliar() {
        return tbSchpGrupoFamiliarByFamiGrupoFamiliar;
    }

    public void setTbSchpGrupoFamiliarByFamiGrupoFamiliar(GrupoFamiliarEntity tbSchpGrupoFamiliarByFamiGrupoFamiliar) {
        this.tbSchpGrupoFamiliarByFamiGrupoFamiliar = tbSchpGrupoFamiliarByFamiGrupoFamiliar;
    }

    @ManyToOne
    @JoinColumn(name = "FAMI_Parentesco", referencedColumnName = "PARA_Id", insertable = false, updatable = false)
    public ParametrosEntity getTbSchmParametrosByFamiParentesco() {
        return tbSchmParametrosByFamiParentesco;
    }

    public void setTbSchmParametrosByFamiParentesco(ParametrosEntity tbSchmParametrosByFamiParentesco) {
        this.tbSchmParametrosByFamiParentesco = tbSchmParametrosByFamiParentesco;
    }

    @OneToMany(mappedBy = "tbSchpFamiliaresByTelfFamiliar")
    public Collection<TelFamiliarEntity> getTbSchpTelFamiliarsByFamiRut() {
        return tbSchpTelFamiliarsByFamiRut;
    }

    public void setTbSchpTelFamiliarsByFamiRut(Collection<TelFamiliarEntity> tbSchpTelFamiliarsByFamiRut) {
        this.tbSchpTelFamiliarsByFamiRut = tbSchpTelFamiliarsByFamiRut;
    }
}
