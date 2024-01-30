package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="stages")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String desciption;
    @ManyToMany
    private List<Personne> stagiaires = new ArrayList<>();

    public Stage() {
    }

    public Stage(String titre, String desciption) {
        this.titre = titre;
        this.desciption = desciption;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public List<Personne> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<Personne> stagiaires) {
        this.stagiaires = stagiaires;
    }

    public void addStagiaire(Personne stagiaire) {
        this.stagiaires.add(stagiaire);
    }
}
