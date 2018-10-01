package com.hardnets.gescolar.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHM_Menu", schema = "dbo", catalog = "kimeltu")
public class MenuEntity {
    private String menuNombre;
    private String menuUrl;
    private String menuPerfiles;
    private byte menuPadre;
    private String menuUrlRef;

    @Id
    @Column(name = "MENU_Nombre")
    public String getMenuNombre() {
        return menuNombre;
    }

    public void setMenuNombre(String menuNombre) {
        this.menuNombre = menuNombre;
    }

    @Basic
    @Column(name = "MENU_Url")
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Basic
    @Column(name = "MENU_Perfiles", columnDefinition = "nvarchar(100)")
    public String getMenuPerfiles() {
        return menuPerfiles;
    }

    public void setMenuPerfiles(String menuPerfiles) {
        this.menuPerfiles = menuPerfiles;
    }

    @Basic
    @Column(name = "MENU_Padre")
    public byte getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(byte menuPadre) {
        this.menuPadre = menuPadre;
    }

    @Basic
    @Column(name = "MENU_UrlRef")
    public String getMenuUrlRef() {
        return menuUrlRef;
    }

    public void setMenuUrlRef(String menuUrlRef) {
        this.menuUrlRef = menuUrlRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return menuPadre == that.menuPadre &&
                Objects.equals(menuNombre, that.menuNombre) &&
                Objects.equals(menuUrl, that.menuUrl) &&
                Objects.equals(menuPerfiles, that.menuPerfiles) &&
                Objects.equals(menuUrlRef, that.menuUrlRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuNombre, menuUrl, menuPerfiles, menuPadre, menuUrlRef);
    }
}
