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
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "zamowienie_produkt")
@NamedQueries({
    @NamedQuery(name = "ZamowienieProdukt.findAll", query = "SELECT z FROM ZamowienieProdukt z"),
    @NamedQuery(name = "ZamowienieProdukt.findByIdZP", query = "SELECT z FROM ZamowienieProdukt z WHERE z.idZP = :idZP"),
    @NamedQuery(name = "ZamowienieProdukt.findByIlosc", query = "SELECT z FROM ZamowienieProdukt z WHERE z.ilosc = :ilosc"),
    @NamedQuery(name = "ZamowienieProdukt.findByKwota", query = "SELECT z FROM ZamowienieProdukt z WHERE z.kwota = :kwota")})
public class ZamowienieProdukt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_z_p")
    private Integer idZP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ilosc")
    private int ilosc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kwota")
    private float kwota;
    @JoinColumn(name = "id_produktu", referencedColumnName = "id_produktu")
    @ManyToOne(optional = false)
    private Produkt idProduktu;
    @JoinColumn(name = "id_zamowienia", referencedColumnName = "id_zamowienia")
    @ManyToOne(optional = false)
    private Zamowienie idZamowienia;

    public ZamowienieProdukt() {
    }

    public ZamowienieProdukt(Integer idZP) {
        this.idZP = idZP;
    }

    public ZamowienieProdukt(Integer idZP, int ilosc, float kwota) {
        this.idZP = idZP;
        this.ilosc = ilosc;
        this.kwota = kwota;
    }

    public Integer getIdZP() {
        return idZP;
    }

    public void setIdZP(Integer idZP) {
        this.idZP = idZP;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    public Produkt getIdProduktu() {
        return idProduktu;
    }

    public void setIdProduktu(Produkt idProduktu) {
        this.idProduktu = idProduktu;
    }

    public Zamowienie getIdZamowienia() {
        return idZamowienia;
    }

    public void setIdZamowienia(Zamowienie idZamowienia) {
        this.idZamowienia = idZamowienia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZP != null ? idZP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZamowienieProdukt)) {
            return false;
        }
        ZamowienieProdukt other = (ZamowienieProdukt) object;
        if ((this.idZP == null && other.idZP != null) || (this.idZP != null && !this.idZP.equals(other.idZP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.ZamowienieProdukt[ idZP=" + idZP + " ]";
    }
    
}
