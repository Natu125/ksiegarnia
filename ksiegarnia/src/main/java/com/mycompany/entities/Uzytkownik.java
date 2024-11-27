/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "uzytkownik")
@NamedQueries({
    @NamedQuery(name = "Uzytkownik.findAll", query = "SELECT u FROM Uzytkownik u"),
    @NamedQuery(name = "Uzytkownik.findByIdUzytkownika", query = "SELECT u FROM Uzytkownik u WHERE u.idUzytkownika = :idUzytkownika"),
    @NamedQuery(name = "Uzytkownik.findByImie", query = "SELECT u FROM Uzytkownik u WHERE u.imie = :imie"),
    @NamedQuery(name = "Uzytkownik.findByNazwisko", query = "SELECT u FROM Uzytkownik u WHERE u.nazwisko = :nazwisko"),
    @NamedQuery(name = "Uzytkownik.findByEmail", query = "SELECT u FROM Uzytkownik u WHERE u.email = :email"),
    @NamedQuery(name = "Uzytkownik.findByHaslo", query = "SELECT u FROM Uzytkownik u WHERE u.haslo = :haslo"),
    @NamedQuery(name = "Uzytkownik.findByDataRejestracji", query = "SELECT u FROM Uzytkownik u WHERE u.dataRejestracji = :dataRejestracji")})
public class Uzytkownik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_uzytkownika")
    private Integer idUzytkownika;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nazwisko")
    private String nazwisko;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "haslo")
    private String haslo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_rejestracji")
    @Temporal(TemporalType.DATE)
    private Date dataRejestracji;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUzytkownika")
    private Collection<Katalog> katalogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKtoDodal")
    private Collection<Katalog> katalogCollection1;
    @JoinColumn(name = "id_adresu", referencedColumnName = "id_adresu_dostawy")
    @ManyToOne
    private AdresDostawy idAdresu;
    @OneToMany(mappedBy = "idKtoZarejestrowal")
    private Collection<Uzytkownik> uzytkownikCollection;
    @JoinColumn(name = "id_kto_zarejestrowal", referencedColumnName = "id_uzytkownika")
    @ManyToOne
    private Uzytkownik idKtoZarejestrowal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKtoDodal")
    private Collection<AdresDostawy> adresDostawyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUzytkownika")
    private Collection<AdresDostawy> adresDostawyCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKlienta")
    private Collection<Zamowienie> zamowienieCollection;

    public Uzytkownik() {
    }

    public Uzytkownik(Integer idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Uzytkownik(Integer idUzytkownika, String imie, String nazwisko, String email, String haslo, Date dataRejestracji) {
        this.idUzytkownika = idUzytkownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.dataRejestracji = dataRejestracji;
    }

    public Integer getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Integer idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Date getDataRejestracji() {
        return dataRejestracji;
    }

    public void setDataRejestracji(Date dataRejestracji) {
        this.dataRejestracji = dataRejestracji;
    }

    public Collection<Katalog> getKatalogCollection() {
        return katalogCollection;
    }

    public void setKatalogCollection(Collection<Katalog> katalogCollection) {
        this.katalogCollection = katalogCollection;
    }

    public Collection<Katalog> getKatalogCollection1() {
        return katalogCollection1;
    }

    public void setKatalogCollection1(Collection<Katalog> katalogCollection1) {
        this.katalogCollection1 = katalogCollection1;
    }

    public AdresDostawy getIdAdresu() {
        return idAdresu;
    }

    public void setIdAdresu(AdresDostawy idAdresu) {
        this.idAdresu = idAdresu;
    }

    public Collection<Uzytkownik> getUzytkownikCollection() {
        return uzytkownikCollection;
    }

    public void setUzytkownikCollection(Collection<Uzytkownik> uzytkownikCollection) {
        this.uzytkownikCollection = uzytkownikCollection;
    }

    public Uzytkownik getIdKtoZarejestrowal() {
        return idKtoZarejestrowal;
    }

    public void setIdKtoZarejestrowal(Uzytkownik idKtoZarejestrowal) {
        this.idKtoZarejestrowal = idKtoZarejestrowal;
    }

    public Collection<AdresDostawy> getAdresDostawyCollection() {
        return adresDostawyCollection;
    }

    public void setAdresDostawyCollection(Collection<AdresDostawy> adresDostawyCollection) {
        this.adresDostawyCollection = adresDostawyCollection;
    }

    public Collection<AdresDostawy> getAdresDostawyCollection1() {
        return adresDostawyCollection1;
    }

    public void setAdresDostawyCollection1(Collection<AdresDostawy> adresDostawyCollection1) {
        this.adresDostawyCollection1 = adresDostawyCollection1;
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
        hash += (idUzytkownika != null ? idUzytkownika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzytkownik)) {
            return false;
        }
        Uzytkownik other = (Uzytkownik) object;
        if ((this.idUzytkownika == null && other.idUzytkownika != null) || (this.idUzytkownika != null && !this.idUzytkownika.equals(other.idUzytkownika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Uzytkownik[ idUzytkownika=" + idUzytkownika + " ]";
    }
    
}
