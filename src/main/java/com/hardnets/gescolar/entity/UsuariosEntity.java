package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Usuarios", schema = "dbo", catalog = "kimeltu")
public class UsuariosEntity {
    private String usurRut;
    private String usurNombre;
    private String usurRol;
    private byte[] usurPassword;
    private String usurMail;
    private Boolean usurEstado;
    private Date usurRegistro;
    private Timestamp usurUltimoLogin;
    private RecuperarClaveEntity tbSchmRecuperarClaveByUsurRut;

    @Id
    @Column(name = "USUR_Rut")
    public String getUsurRut() {
        return usurRut;
    }

    public void setUsurRut(String usurRut) {
        this.usurRut = usurRut;
    }

    @Basic
    @Column(name = "USUR_Nombre")
    public String getUsurNombre() {
        return usurNombre;
    }

    public void setUsurNombre(String usurNombre) {
        this.usurNombre = usurNombre;
    }

    @Basic
    @Column(name = "USUR_Rol")
    public String getUsurRol() {
        return usurRol;
    }

    public void setUsurRol(String usurRol) {
        this.usurRol = usurRol;
    }

    @Basic
    @Column(name = "USUR_Password")
    public byte[] getUsurPassword() {
        return usurPassword;
    }

    public void setUsurPassword(byte[] usurPassword) {
        this.usurPassword = usurPassword;
    }

    @Basic
    @Column(name = "USUR_Mail")
    public String getUsurMail() {
        return usurMail;
    }

    public void setUsurMail(String usurMail) {
        this.usurMail = usurMail;
    }

    @Basic
    @Column(name = "USUR_Estado")
    public Boolean getUsurEstado() {
        return usurEstado;
    }

    public void setUsurEstado(Boolean usurEstado) {
        this.usurEstado = usurEstado;
    }

    @Basic
    @Column(name = "USUR_Registro")
    public Date getUsurRegistro() {
        return usurRegistro;
    }

    public void setUsurRegistro(Date usurRegistro) {
        this.usurRegistro = usurRegistro;
    }

    @Basic
    @Column(name = "USUR_UltimoLogin")
    public Timestamp getUsurUltimoLogin() {
        return usurUltimoLogin;
    }

    public void setUsurUltimoLogin(Timestamp usurUltimoLogin) {
        this.usurUltimoLogin = usurUltimoLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosEntity that = (UsuariosEntity) o;
        return Objects.equals(usurRut, that.usurRut) &&
                Objects.equals(usurNombre, that.usurNombre) &&
                Objects.equals(usurRol, that.usurRol) &&
                Arrays.equals(usurPassword, that.usurPassword) &&
                Objects.equals(usurMail, that.usurMail) &&
                Objects.equals(usurEstado, that.usurEstado) &&
                Objects.equals(usurRegistro, that.usurRegistro) &&
                Objects.equals(usurUltimoLogin, that.usurUltimoLogin);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(usurRut, usurNombre, usurRol, usurMail, usurEstado, usurRegistro, usurUltimoLogin);
        result = 31 * result + Arrays.hashCode(usurPassword);
        return result;
    }

    @OneToOne(mappedBy = "tbSchmUsuariosByRclaUsuario")
    public RecuperarClaveEntity getTbSchmRecuperarClaveByUsurRut() {
        return tbSchmRecuperarClaveByUsurRut;
    }

    public void setTbSchmRecuperarClaveByUsurRut(RecuperarClaveEntity tbSchmRecuperarClaveByUsurRut) {
        this.tbSchmRecuperarClaveByUsurRut = tbSchmRecuperarClaveByUsurRut;
    }
}
