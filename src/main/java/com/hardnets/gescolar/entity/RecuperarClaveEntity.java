package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_RecuperarClave", schema = "dbo", catalog = "kimeltu")
public class RecuperarClaveEntity {
    private String rclaUsuario;
    private Timestamp rclaFechaSolicitud;
    private String rclaEstado;
    private byte[] rclaNuevaClave;
    private UsuariosEntity tbSchmUsuariosByRclaUsuario;

    @Id
    @Column(name = "RCLA_Usuario")
    public String getRclaUsuario() {
        return rclaUsuario;
    }

    public void setRclaUsuario(String rclaUsuario) {
        this.rclaUsuario = rclaUsuario;
    }

    @Basic
    @Column(name = "RCLA_FechaSolicitud")
    public Timestamp getRclaFechaSolicitud() {
        return rclaFechaSolicitud;
    }

    public void setRclaFechaSolicitud(Timestamp rclaFechaSolicitud) {
        this.rclaFechaSolicitud = rclaFechaSolicitud;
    }

    @Basic
    @Column(name = "RCLA_Estado")
    public String getRclaEstado() {
        return rclaEstado;
    }

    public void setRclaEstado(String rclaEstado) {
        this.rclaEstado = rclaEstado;
    }

    @Basic
    @Column(name = "RCLA_NuevaClave")
    public byte[] getRclaNuevaClave() {
        return rclaNuevaClave;
    }

    public void setRclaNuevaClave(byte[] rclaNuevaClave) {
        this.rclaNuevaClave = rclaNuevaClave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecuperarClaveEntity that = (RecuperarClaveEntity) o;
        return Objects.equals(rclaUsuario, that.rclaUsuario) &&
                Objects.equals(rclaFechaSolicitud, that.rclaFechaSolicitud) &&
                Objects.equals(rclaEstado, that.rclaEstado) &&
                Arrays.equals(rclaNuevaClave, that.rclaNuevaClave);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rclaUsuario, rclaFechaSolicitud, rclaEstado);
        result = 31 * result + Arrays.hashCode(rclaNuevaClave);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "RCLA_Usuario", referencedColumnName = "USUR_Rut", nullable = false)
    public UsuariosEntity getTbSchmUsuariosByRclaUsuario() {
        return tbSchmUsuariosByRclaUsuario;
    }

    public void setTbSchmUsuariosByRclaUsuario(UsuariosEntity tbSchmUsuariosByRclaUsuario) {
        this.tbSchmUsuariosByRclaUsuario = tbSchmUsuariosByRclaUsuario;
    }
}
