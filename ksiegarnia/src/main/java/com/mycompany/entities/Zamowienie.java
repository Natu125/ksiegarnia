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
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "zamowienie")
@NamedQueries({
    @NamedQuery(name = "Zamowienie.findAll", query = "SELECT z FROM Zamowienie z"),
    @NamedQuery(name = "Zamowienie.findByIdZamowienia", query = "SELECT z FROM Zamowienie z WHERE z.idZamowienia = :idZamowienia"),
    @NamedQuery(name = "Zamowienie.findByData", query = "SELECT z FROM Zamowienie z WHERE z.data = :data"),
    @NamedQuery(name = "Zamowienie.findBySuma", query = "SELECT z FROM Zamowienie z WHERE z.suma = :suma")})
public class Zamowienie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zamowienia")
    private Integer idZamowienia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suma")
    private float suma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZamowienia")
    private Collection<ZamowienieProdukt> zamowienieProduktCollection;
    @JoinColumn(name = "id_adresu_dostawy", referencedColumnName = "id_adresu_dostawy")
    @ManyToOne
    private AdresDostawy idAdresuDostawy;
    @JoinColumn(name = "id_klienta", referencedColumnName = "id_uzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownik idKlienta;

    public Zamowienie() {
    }

    public Zamowienie(Integer idZamowienia) {
        this.idZamowienia = idZamowienia;
    }

    public Zamowienie(Integer idZamowienia, Date data, float suma) {
        this.idZamowienia = idZamowienia;
        this.data = data;
        this.suma = suma;
    }

    public Integer getIdZamowienia() {
        return idZamowienia;
    }

    public void setIdZamowienia(Integer idZamowienia) {
        this.idZamowienia = idZamowienia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getSuma() {
        return suma;
    }

    public void setSuma(float suma) {
        this.suma = suma;
    }

    public Collection<ZamowienieProdukt> getZamowienieProduktCollection() {
        return zamowienieProduktCollection;
    }

    public void setZamowienieProduktCollection(Collection<ZamowienieProdukt> zamowienieProduktCollection) {
        this.zamowienieProduktCollection = zamowienieProduktCollection;
    }

    public AdresDostawy getIdAdresuDostawy() {
        return idAdresuDostawy;
    }

    public void setIdAdresuDostawy(AdresDostawy idAdresuDostawy) {
        this.idAdresuDostawy = idAdresuDostawy;
    }

    public Uzytkownik getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Uzytkownik idKlienta) {
        this.idKlienta = idKlienta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZamowienia != null ? idZamowienia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zamowienie)) {
            return false;
        }
        Zamowienie other = (Zamowienie) object;
        if ((this.idZamowienia == null && other.idZamowienia != null) || (this.idZamowienia != null && !this.idZamowienia.equals(other.idZamowienia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Zamowienie[ idZamowienia=" + idZamowienia + " ]";
    }
    
}
