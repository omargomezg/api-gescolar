package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Alumno", schema = "dbo", catalog = "kimeltu")
public class AlumnoEntity {
    private String almnRut;
    private String almnNombres;
    private String almnApPaterno;
    private String almnApMaterno;
    private Date almnNacimiento;
    private Short almnDomicilio;
    private String almnEstado;
    private String almnGenero;
    private String almnApoderado;
    private Collection<AlumnoClaseEntity> tbSchmAlumnoClasesByAlmnRut;
    private Collection<LogAlumnoEntity> tbSchmLogAlumnosByAlmnRut;
    private DomicilioEntity tbSchpDomicilioByAlmnDomicilio;
    private FamiliaresEntity tbSchpFamiliaresByAlmnApoderado;
    private Collection<ClaseEntity> tbSchpClasesByAlmnRut;
    private Collection<ColegiaturaEntity> tbSchpColegiaturasByAlmnRut;
    private Collection<CompromisoPagoEntity> tbSchpCompromisoPagosByAlmnRut;
    private Collection<DescuentoAlumnoEntity> tbSchpDescuentoAlumnosByAlmnRut;
    private Collection<GrupoFamiliarEntity> tbSchpGrupoFamiliarsByAlmnRut;
    private Collection<PostulacionEntity> tbSchpPostulacionsByAlmnRut;

    @Id
    @Column(name = "ALMN_Rut")
    public String getAlmnRut() {
        return almnRut;
    }

    public void setAlmnRut(String almnRut) {
        this.almnRut = almnRut;
    }

    @Basic
    @Column(name = "ALMN_Nombres")
    public String getAlmnNombres() {
        return almnNombres;
    }

    public void setAlmnNombres(String almnNombres) {
        this.almnNombres = almnNombres;
    }

    @Basic
    @Column(name = "ALMN_ApPaterno")
    public String getAlmnApPaterno() {
        return almnApPaterno;
    }

    public void setAlmnApPaterno(String almnApPaterno) {
        this.almnApPaterno = almnApPaterno;
    }

    @Basic
    @Column(name = "ALMN_ApMaterno")
    public String getAlmnApMaterno() {
        return almnApMaterno;
    }

    public void setAlmnApMaterno(String almnApMaterno) {
        this.almnApMaterno = almnApMaterno;
    }

    @Basic
    @Column(name = "ALMN_Nacimiento")
    public Date getAlmnNacimiento() {
        return almnNacimiento;
    }

    public void setAlmnNacimiento(Date almnNacimiento) {
        this.almnNacimiento = almnNacimiento;
    }

    @Basic
    @Column(name = "ALMN_Domicilio")
    public Short getAlmnDomicilio() {
        return almnDomicilio;
    }

    public void setAlmnDomicilio(Short almnDomicilio) {
        this.almnDomicilio = almnDomicilio;
    }

    @Basic
    @Column(name = "ALMN_Estado")
    public String getAlmnEstado() {
        return almnEstado;
    }

    public void setAlmnEstado(String almnEstado) {
        this.almnEstado = almnEstado;
    }

    @Basic
    @Column(name = "ALMN_Genero")
    public String getAlmnGenero() {
        return almnGenero;
    }

    public void setAlmnGenero(String almnGenero) {
        this.almnGenero = almnGenero;
    }

    @Basic
    @Column(name = "ALMN_Apoderado")
    public String getAlmnApoderado() {
        return almnApoderado;
    }

    public void setAlmnApoderado(String almnApoderado) {
        this.almnApoderado = almnApoderado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoEntity that = (AlumnoEntity) o;
        return Objects.equals(almnRut, that.almnRut) &&
                Objects.equals(almnNombres, that.almnNombres) &&
                Objects.equals(almnApPaterno, that.almnApPaterno) &&
                Objects.equals(almnApMaterno, that.almnApMaterno) &&
                Objects.equals(almnNacimiento, that.almnNacimiento) &&
                Objects.equals(almnDomicilio, that.almnDomicilio) &&
                Objects.equals(almnEstado, that.almnEstado) &&
                Objects.equals(almnGenero, that.almnGenero) &&
                Objects.equals(almnApoderado, that.almnApoderado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(almnRut, almnNombres, almnApPaterno, almnApMaterno, almnNacimiento, almnDomicilio, almnEstado, almnGenero, almnApoderado);
    }

    @OneToMany(mappedBy = "tbSchpAlumnoByAcurAlumno")
    public Collection<AlumnoClaseEntity> getTbSchmAlumnoClasesByAlmnRut() {
        return tbSchmAlumnoClasesByAlmnRut;
    }

    public void setTbSchmAlumnoClasesByAlmnRut(Collection<AlumnoClaseEntity> tbSchmAlumnoClasesByAlmnRut) {
        this.tbSchmAlumnoClasesByAlmnRut = tbSchmAlumnoClasesByAlmnRut;
    }

    @OneToMany(mappedBy = "tbSchpAlumnoByLalmRut")
    public Collection<LogAlumnoEntity> getTbSchmLogAlumnosByAlmnRut() {
        return tbSchmLogAlumnosByAlmnRut;
    }

    public void setTbSchmLogAlumnosByAlmnRut(Collection<LogAlumnoEntity> tbSchmLogAlumnosByAlmnRut) {
        this.tbSchmLogAlumnosByAlmnRut = tbSchmLogAlumnosByAlmnRut;
    }

    @ManyToOne
    @JoinColumn(name = "ALMN_Domicilio", referencedColumnName = "DOMI_Id", insertable = false, updatable = false)
    public DomicilioEntity getTbSchpDomicilioByAlmnDomicilio() {
        return tbSchpDomicilioByAlmnDomicilio;
    }

    public void setTbSchpDomicilioByAlmnDomicilio(DomicilioEntity tbSchpDomicilioByAlmnDomicilio) {
        this.tbSchpDomicilioByAlmnDomicilio = tbSchpDomicilioByAlmnDomicilio;
    }

    @ManyToOne
    @JoinColumn(name = "ALMN_Apoderado", referencedColumnName = "FAMI_Rut", insertable = false, updatable = false)
    public FamiliaresEntity getTbSchpFamiliaresByAlmnApoderado() {
        return tbSchpFamiliaresByAlmnApoderado;
    }

    public void setTbSchpFamiliaresByAlmnApoderado(FamiliaresEntity tbSchpFamiliaresByAlmnApoderado) {
        this.tbSchpFamiliaresByAlmnApoderado = tbSchpFamiliaresByAlmnApoderado;
    }

    @OneToMany(mappedBy = "tbSchpAlumnoByClasAlumno")
    public Collection<ClaseEntity> getTbSchpClasesByAlmnRut() {
        return tbSchpClasesByAlmnRut;
    }

    public void setTbSchpClasesByAlmnRut(Collection<ClaseEntity> tbSchpClasesByAlmnRut) {
        this.tbSchpClasesByAlmnRut = tbSchpClasesByAlmnRut;
    }

    @OneToMany(mappedBy = "tbSchpAlumnoByColeAlumno")
    public Collection<ColegiaturaEntity> getTbSchpColegiaturasByAlmnRut() {
        return tbSchpColegiaturasByAlmnRut;
    }

    public void setTbSchpColegiaturasByAlmnRut(Collection<ColegiaturaEntity> tbSchpColegiaturasByAlmnRut) {
        this.tbSchpColegiaturasByAlmnRut = tbSchpColegiaturasByAlmnRut;
    }

    @OneToMany(mappedBy = "tbSchpAlumnoByCompAlumno")
    public Collection<CompromisoPagoEntity> getTbSchpCompromisoPagosByAlmnRut() {
        return tbSchpCompromisoPagosByAlmnRut;
    }

    public void setTbSchpCompromisoPagosByAlmnRut(Collection<CompromisoPagoEntity> tbSchpCompromisoPagosByAlmnRut) {
        this.tbSchpCompromisoPagosByAlmnRut = tbSchpCompromisoPagosByAlmnRut;
    }

    @OneToMany(mappedBy = "tbSchpAlumnoByDscaAlumno")
    public Collection<DescuentoAlumnoEntity> getTbSchpDescuentoAlumnosByAlmnRut() {
        return tbSchpDescuentoAlumnosByAlmnRut;
    }

    public void setTbSchpDescuentoAlumnosByAlmnRut(Collection<DescuentoAlumnoEntity> tbSchpDescuentoAlumnosByAlmnRut) {
        this.tbSchpDescuentoAlumnosByAlmnRut = tbSchpDescuentoAlumnosByAlmnRut;
    }

    @OneToMany(mappedBy = "tbSchpAlumnoByGfamAlumno")
    public Collection<GrupoFamiliarEntity> getTbSchpGrupoFamiliarsByAlmnRut() {
        return tbSchpGrupoFamiliarsByAlmnRut;
    }

    public void setTbSchpGrupoFamiliarsByAlmnRut(Collection<GrupoFamiliarEntity> tbSchpGrupoFamiliarsByAlmnRut) {
        this.tbSchpGrupoFamiliarsByAlmnRut = tbSchpGrupoFamiliarsByAlmnRut;
    }

    @OneToMany(mappedBy = "tbSchpAlumnoByPostAlumno")
    public Collection<PostulacionEntity> getTbSchpPostulacionsByAlmnRut() {
        return tbSchpPostulacionsByAlmnRut;
    }

    public void setTbSchpPostulacionsByAlmnRut(Collection<PostulacionEntity> tbSchpPostulacionsByAlmnRut) {
        this.tbSchpPostulacionsByAlmnRut = tbSchpPostulacionsByAlmnRut;
    }
}
