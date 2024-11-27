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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "produkt")
@NamedQueries({
    @NamedQuery(name = "Produkt.findAll", query = "SELECT p FROM Produkt p"),
    @NamedQuery(name = "Produkt.findByIdProduktu", query = "SELECT p FROM Produkt p WHERE p.idProduktu = :idProduktu"),
    @NamedQuery(name = "Produkt.findByNazwa", query = "SELECT p FROM Produkt p WHERE p.nazwa = :nazwa"),
    @NamedQuery(name = "Produkt.findByCena", query = "SELECT p FROM Produkt p WHERE p.cena = :cena"),
    @NamedQuery(name = "Produkt.findByOpis", query = "SELECT p FROM Produkt p WHERE p.opis = :opis"),
    @NamedQuery(name = "Produkt.findByDostepnosc", query = "SELECT p FROM Produkt p WHERE p.dostepnosc = :dostepnosc"),
    @NamedQuery(name = "Produkt.findByObrazek", query = "SELECT p FROM Produkt p WHERE p.obrazek = :obrazek")})
public class Produkt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produktu")
    private Integer idProduktu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwa")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena")
    private float cena;
    @Size(max = 1000)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dostepnosc")
    private int dostepnosc;
    @Size(max = 150)
    @Column(name = "obrazek")
    private String obrazek;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduktu")
    private Collection<ZamowienieProdukt> zamowienieProduktCollection;
    @JoinColumn(name = "id_autora", referencedColumnName = "id_autora")
    @ManyToOne(optional = false)
    private Autor idAutora;

    public Produkt() {
    }

    public Produkt(Integer idProduktu) {
        this.idProduktu = idProduktu;
    }

    public Produkt(Integer idProduktu, String nazwa, float cena, int dostepnosc) {
        this.idProduktu = idProduktu;
        this.nazwa = nazwa;
        this.cena = cena;
        this.dostepnosc = dostepnosc;
    }

    public Integer getIdProduktu() {
        return idProduktu;
    }

    public void setIdProduktu(Integer idProduktu) {
        this.idProduktu = idProduktu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getDostepnosc() {
        return dostepnosc;
    }

    public void setDostepnosc(int dostepnosc) {
        this.dostepnosc = dostepnosc;
    }

    public String getObrazek() {
        return obrazek;
    }

    public void setObrazek(String obrazek) {
        this.obrazek = obrazek;
    }

    public Collection<ZamowienieProdukt> getZamowienieProduktCollection() {
        return zamowienieProduktCollection;
    }

    public void setZamowienieProduktCollection(Collection<ZamowienieProdukt> zamowienieProduktCollection) {
        this.zamowienieProduktCollection = zamowienieProduktCollection;
    }

    public Autor getIdAutora() {
        return idAutora;
    }

    public void setIdAutora(Autor idAutora) {
        this.idAutora = idAutora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduktu != null ? idProduktu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produkt)) {
            return false;
        }
        Produkt other = (Produkt) object;
        if ((this.idProduktu == null && other.idProduktu != null) || (this.idProduktu != null && !this.idProduktu.equals(other.idProduktu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Produkt[ idProduktu=" + idProduktu + " ]";
    }
    
}
