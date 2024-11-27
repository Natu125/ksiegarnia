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
@Table(name = "autor")
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.findByIdAutora", query = "SELECT a FROM Autor a WHERE a.idAutora = :idAutora"),
    @NamedQuery(name = "Autor.findByImie", query = "SELECT a FROM Autor a WHERE a.imie = :imie"),
    @NamedQuery(name = "Autor.findByNazwisko", query = "SELECT a FROM Autor a WHERE a.nazwisko = :nazwisko")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autora")
    private Integer idAutora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "imie")
    private String imie;
    @Size(max = 35)
    @Column(name = "nazwisko")
    private String nazwisko;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutora")
    private Collection<Produkt> produktCollection;

    public Autor() {
    }

    public Autor(Integer idAutora) {
        this.idAutora = idAutora;
    }

    public Autor(Integer idAutora, String imie) {
        this.idAutora = idAutora;
        this.imie = imie;
    }

    public Integer getIdAutora() {
        return idAutora;
    }

    public void setIdAutora(Integer idAutora) {
        this.idAutora = idAutora;
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

    public Collection<Produkt> getProduktCollection() {
        return produktCollection;
    }

    public void setProduktCollection(Collection<Produkt> produktCollection) {
        this.produktCollection = produktCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutora != null ? idAutora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.idAutora == null && other.idAutora != null) || (this.idAutora != null && !this.idAutora.equals(other.idAutora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entities.Autor[ idAutora=" + idAutora + " ]";
    }
    
}
