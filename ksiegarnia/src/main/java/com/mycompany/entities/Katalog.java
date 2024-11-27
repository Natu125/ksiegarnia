/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "katalog")
@NamedQueries({
    @NamedQuery(name = "Katalog.findAll", query = "SELECT k FROM Katalog k"),
    @NamedQuery(name = "Katalog.findByIdKatalogu", query = "SELECT k FROM Katalog k WHERE k.idKatalogu = :idKatalogu")})
public class Katalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_katalogu")
    private Integer idKatalogu;
    @JoinColumn(name = "id_roli", referencedColumnName = "id_roli")
    @ManyToOne(optional = false)
    private Rola idRoli;
    @JoinColumn(name = "id_uzytkownika", referencedColumnName = "id_uzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownik idUzytkownika;
    @JoinColumn(name = "id_kto_dodal", referencedColumnName = "id_uzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownik idKtoDodal;

    public Katalog() {
    }

    public Katalog(Integer idKatalogu) {
        this.idKatalogu = idKatalogu;
    }

    public Integer getIdKatalogu() {
        return idKatalogu;
    }

    public void setIdKatalogu(Integer idKatalogu) {
        this.idKatalogu = idKatalogu;
    }

    public Rola getIdRoli() {
        return idRoli;
    }

    public void setIdRoli(Rola idRoli) {
        this.idRoli = idRoli;
    }

    public Uzytkownik getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Uzytkownik idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Uzytkownik getIdKtoDodal() {
        return idKtoDodal;
    }

    public void setIdKtoDodal(Uzytkownik idKtoDodal) {
        this.idKtoDodal = idKtoDodal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKatalogu != null ? idKatalogu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Katalog)) {
            return false;
        }
        Katalog other = (Katalog) object;
        if ((this.idKatalogu == null && other.idKatalogu != null) || (this.idKatalogu != null && !this.idKatalogu.equals(other.idKatalogu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Katalog[ idKatalogu=" + idKatalogu + " ]";
    }
    
}
