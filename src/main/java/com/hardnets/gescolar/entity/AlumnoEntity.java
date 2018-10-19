package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_Alumno", schema = "dbo")
public class AlumnoEntity {
    private String rut;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
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
    @Column(name = "ALMN_Rut", columnDefinition = "nvarchar(10)")
    public String getRut() {
        return rut;
    }

    public void setRut(String Rut) {
        this.rut = Rut;
    }

    @Basic
    @Column(name = "ALMN_Nombres")
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "ALMN_ApPaterno")
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Basic
    @Column(name = "ALMN_ApMaterno")
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Basic
    @Column(name = "ALMN_Nacimiento")
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
    @Column(name = "ALMN_Estado", columnDefinition = "nchar(10)")
    public String getAlmnEstado() {
        return almnEstado;
    }

    public void setAlmnEstado(String almnEstado) {
        this.almnEstado = almnEstado;
    }

    @Basic
    @Column(name = "ALMN_Genero", columnDefinition = "nchar(1)")
    public String getAlmnGenero() {
        return almnGenero;
    }

    public void setAlmnGenero(String almnGenero) {
        this.almnGenero = almnGenero;
    }

    @Basic
    @Column(name = "ALMN_Apoderado", columnDefinition = "nvarchar(10)")
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
        return Objects.equals(rut, that.rut) &&
                Objects.equals(nombres, that.nombres) &&
                Objects.equals(apellidoPaterno, that.apellidoPaterno) &&
                Objects.equals(apellidoMaterno, that.apellidoMaterno) &&
                Objects.equals(fechaNacimiento, that.fechaNacimiento) &&
                Objects.equals(almnDomicilio, that.almnDomicilio) &&
                Objects.equals(almnEstado, that.almnEstado) &&
                Objects.equals(almnGenero, that.almnGenero) &&
                Objects.equals(almnApoderado, that.almnApoderado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rut, nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, almnDomicilio, almnEstado, almnGenero, almnApoderado);
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
