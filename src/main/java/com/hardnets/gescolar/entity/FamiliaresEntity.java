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
    private String rut;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private Integer estadoCivil;
    private String correo;
    private String genero;
    private Integer grupoFamiliar;
    private Integer parentesco;
    private String profesion;
    private String telefonoFijo;
    private String telefonoMovil;
    private Collection<AlumnoEntity> tbSchpAlumnosByFamiRut;
    private ParametrosEntity tbSchmParametrosByFamiEstadoCivil;
    private GrupoFamiliarEntity tbSchpGrupoFamiliarByFamiGrupoFamiliar;
    private ParametrosEntity tbSchmParametrosByFamiParentesco;
    private Collection<TelFamiliarEntity> tbSchpTelFamiliarsByFamiRut;

    @Override
    public String toString() {
        return "FamiliaresEntity{" +
                "rut='" + rut + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", estadoCivil=" + estadoCivil +
                ", correo='" + correo + '\'' +
                ", genero='" + genero + '\'' +
                ", grupoFamiliar=" + grupoFamiliar +
                ", parentesco=" + parentesco +
                ", profesion='" + profesion + '\'' +
                ", telefonoFijo='" + telefonoFijo + '\'' +
                ", telefonoMovil='" + telefonoMovil + '\'' +
                '}';
    }

    @Id
    @Column(name = "FAMI_Rut", columnDefinition = "nvarchar(10)", unique = true, nullable = false)
    public String getRut() {
        return rut;
    }

    public void setRut(String Rut) {
        this.rut = Rut;
    }

    @Basic
    @Column(name = "FAMI_Nombres", columnDefinition = "varchar(255)")
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "FAMI_ApPaterno", columnDefinition = "varchar(255)")
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Basic
    @Column(name = "FAMI_ApMaterno", columnDefinition = "varchar(255)")
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Basic
    @Column(name = "FAMI_Nacimiento")
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "FAMI_EstadoCivil")
    public Integer getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Integer estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Basic
    @Column(name = "FAMI_Correo", columnDefinition = "varchar(200)")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "FAMI_Genero", columnDefinition = "nchar(1)")
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Basic
    @Column(name = "FAMI_GrupoFamiliar")
    public Integer getGrupoFamiliar() {
        return grupoFamiliar;
    }

    public void setGrupoFamiliar(Integer grupoFamiliar) {
        this.grupoFamiliar = grupoFamiliar;
    }

    @Basic
    @Column(name = "FAMI_Parentesco")
    public Integer getParentesco() {
        return parentesco;
    }

    public void setParentesco(Integer parentesco) {
        this.parentesco = parentesco;
    }

    @Basic
    @Column(name = "FAMI_Profesion", columnDefinition = "nvarchar(100)")
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Basic
    @Column(name = "FAMI_Fijo", columnDefinition = "nvarchar(15)")
    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    @Basic
    @Column(name = "FAMI_Movil", columnDefinition = "nvarchar(15)")
    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

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
                Objects.equals(genero, that.genero) &&
                Objects.equals(grupoFamiliar, that.grupoFamiliar) &&
                Objects.equals(parentesco, that.parentesco) &&
                Objects.equals(profesion, that.profesion) &&
                Objects.equals(telefonoFijo, that.telefonoFijo) &&
                Objects.equals(telefonoMovil, that.telefonoMovil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rut, nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, estadoCivil, correo, genero, grupoFamiliar, parentesco, profesion, telefonoFijo, telefonoMovil);
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

    @OneToMany(mappedBy = "tbSchpFamiliaresByFamiliar")
    public Collection<TelFamiliarEntity> getTbSchpTelFamiliarsByFamiRut() {
        return tbSchpTelFamiliarsByFamiRut;
    }

    public void setTbSchpTelFamiliarsByFamiRut(Collection<TelFamiliarEntity> tbSchpTelFamiliarsByFamiRut) {
        this.tbSchpTelFamiliarsByFamiRut = tbSchpTelFamiliarsByFamiRut;
    }
}
