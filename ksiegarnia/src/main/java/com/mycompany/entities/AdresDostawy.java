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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "adres_dostawy")
@NamedQueries({
    @NamedQuery(name = "AdresDostawy.findAll", query = "SELECT a FROM AdresDostawy a"),
    @NamedQuery(name = "AdresDostawy.findByIdAdresuDostawy", query = "SELECT a FROM AdresDostawy a WHERE a.idAdresuDostawy = :idAdresuDostawy"),
    @NamedQuery(name = "AdresDostawy.findByKraj", query = "SELECT a FROM AdresDostawy a WHERE a.kraj = :kraj"),
    @NamedQuery(name = "AdresDostawy.findByMiejscowosc", query = "SELECT a FROM AdresDostawy a WHERE a.miejscowosc = :miejscowosc"),
    @NamedQuery(name = "AdresDostawy.findByUlicaILokal", query = "SELECT a FROM AdresDostawy a WHERE a.ulicaILokal = :ulicaILokal")})
public class AdresDostawy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adresu_dostawy")
    private Integer idAdresuDostawy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "kraj")
    private String kraj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "miejscowosc")
    private String miejscowosc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "ulica_i_lokal")
    private String ulicaILokal;
    @OneToMany(mappedBy = "idAdresu")
    private Collection<Uzytkownik> uzytkownikCollection;
    @JoinColumn(name = "id_kto_dodal", referencedColumnName = "id_uzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownik idKtoDodal;
    @JoinColumn(name = "id_uzytkownika", referencedColumnName = "id_uzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownik idUzytkownika;
    @OneToMany(mappedBy = "idAdresuDostawy")
    private Collection<Zamowienie> zamowienieCollection;

    public AdresDostawy() {
    }

    public AdresDostawy(Integer idAdresuDostawy) {
        this.idAdresuDostawy = idAdresuDostawy;
    }

    public AdresDostawy(Integer idAdresuDostawy, String kraj, String miejscowosc, String ulicaILokal) {
        this.idAdresuDostawy = idAdresuDostawy;
        this.kraj = kraj;
        this.miejscowosc = miejscowosc;
        this.ulicaILokal = ulicaILokal;
    }

    public Integer getIdAdresuDostawy() {
        return idAdresuDostawy;
    }

    public void setIdAdresuDostawy(Integer idAdresuDostawy) {
        this.idAdresuDostawy = idAdresuDostawy;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlicaILokal() {
        return ulicaILokal;
    }

    public void setUlicaILokal(String ulicaILokal) {
        this.ulicaILokal = ulicaILokal;
    }

    public Collection<Uzytkownik> getUzytkownikCollection() {
        return uzytkownikCollection;
    }

    public void setUzytkownikCollection(Collection<Uzytkownik> uzytkownikCollection) {
        this.uzytkownikCollection = uzytkownikCollection;
    }

    public Uzytkownik getIdKtoDodal() {
        return idKtoDodal;
    }

    public void setIdKtoDodal(Uzytkownik idKtoDodal) {
        this.idKtoDodal = idKtoDodal;
    }

    public Uzytkownik getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Uzytkownik idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Collection<Zamowienie> getZamowienieCollection() {
        return zamowienieCollection;
    }

    public void setZamowienieCollection(Collection<Zamowienie> zamowienieCollection) {
        this.zamowienieCollection = zamowienieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdresuDostawy != null ? idAdresuDostawy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdresDostawy)) {
            return false;
        }
        AdresDostawy other = (AdresDostawy) object;
        if ((this.idAdresuDostawy == null && other.idAdresuDostawy != null) || (this.idAdresuDostawy != null && !this.idAdresuDostawy.equals(other.idAdresuDostawy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.AdresDostawy[ idAdresuDostawy=" + idAdresuDostawy + " ]";
    }
    
}
