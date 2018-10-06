package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Logs", schema = "dbo")
public class LogsEntity {
    private String logsId;
    private String logsData;
    private Timestamp logsFecha;
    private String logsTipo;
    private String logsUsuario;

    @Id
    @Column(name = "LOGS_Id", columnDefinition = "uniqueidentifier")
    public String getLogsId() {
        return logsId;
    }

    public void setLogsId(String logsId) {
        this.logsId = logsId;
    }

    @Basic
    @Column(name = "LOGS_Data", columnDefinition = "nvarchar(540)")
    public String getLogsData() {
        return logsData;
    }

    public void setLogsData(String logsData) {
        this.logsData = logsData;
    }

    @Basic
    @Column(name = "LOGS_Fecha")
    public Timestamp getLogsFecha() {
        return logsFecha;
    }

    public void setLogsFecha(Timestamp logsFecha) {
        this.logsFecha = logsFecha;
    }

    @Basic
    @Column(name = "LOGS_Tipo", columnDefinition = "nvarchar(10)")
    public String getLogsTipo() {
        return logsTipo;
    }

    public void setLogsTipo(String logsTipo) {
        this.logsTipo = logsTipo;
    }

    @Basic
    @Column(name = "LOGS_Usuario", columnDefinition = "nvarchar(10)")
    public String getLogsUsuario() {
        return logsUsuario;
    }

    public void setLogsUsuario(String logsUsuario) {
        this.logsUsuario = logsUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogsEntity that = (LogsEntity) o;
        return logsId == that.logsId &&
                Objects.equals(logsData, that.logsData) &&
                Objects.equals(logsFecha, that.logsFecha) &&
                Objects.equals(logsTipo, that.logsTipo) &&
                Objects.equals(logsUsuario, that.logsUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logsId, logsData, logsFecha, logsTipo, logsUsuario);
    }
}
