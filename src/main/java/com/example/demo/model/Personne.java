package com.example.demo.model;

import com.example.demo.dao.ChienRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="personnes")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore
    private Integer id;
    private String prenom;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Chien> chiens = new ArrayList<>();

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Personne() {
    }

    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addChien(Chien ch) {
        chiens.add(ch);
    }

    public List<Chien> getChiens() {
        return chiens;
    }

    public void setChiens(List<Chien> chiens) {
        this.chiens = chiens;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
