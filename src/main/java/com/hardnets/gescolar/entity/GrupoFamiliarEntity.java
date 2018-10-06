package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHP_GrupoFamiliar", schema = "dbo")
public class GrupoFamiliarEntity {
    private int gfamId;
    private String gfamAlumno;
    private Collection<FamiliaresEntity> tbSchpFamiliaresByGfamId;
    private AlumnoEntity tbSchpAlumnoByGfamAlumno;

    @Id
    @Column(name = "GFAM_Id")
    public int getGfamId() {
        return gfamId;
    }

    public void setGfamId(int gfamId) {
        this.gfamId = gfamId;
    }

    @Basic
    @Column(name = "GFAM_Alumno", columnDefinition = "nvarchar(10)")
    public String getGfamAlumno() {
        return gfamAlumno;
    }

    public void setGfamAlumno(String gfamAlumno) {
        this.gfamAlumno = gfamAlumno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoFamiliarEntity that = (GrupoFamiliarEntity) o;
        return gfamId == that.gfamId &&
                Objects.equals(gfamAlumno, that.gfamAlumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gfamId, gfamAlumno);
    }

    @OneToMany(mappedBy = "tbSchpGrupoFamiliarByFamiGrupoFamiliar")
    public Collection<FamiliaresEntity> getTbSchpFamiliaresByGfamId() {
        return tbSchpFamiliaresByGfamId;
    }

    public void setTbSchpFamiliaresByGfamId(Collection<FamiliaresEntity> tbSchpFamiliaresByGfamId) {
        this.tbSchpFamiliaresByGfamId = tbSchpFamiliaresByGfamId;
    }

    @ManyToOne
    @JoinColumn(name = "GFAM_Alumno", referencedColumnName = "ALMN_Rut", insertable = false, updatable = false)
    public AlumnoEntity getTbSchpAlumnoByGfamAlumno() {
        return tbSchpAlumnoByGfamAlumno;
    }

    public void setTbSchpAlumnoByGfamAlumno(AlumnoEntity tbSchpAlumnoByGfamAlumno) {
        this.tbSchpAlumnoByGfamAlumno = tbSchpAlumnoByGfamAlumno;
    }
}
