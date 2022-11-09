package com.example.centreformation.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "duree")
    private String duree;
    @Column(name = "difficulte")
    @Enumerated(EnumType.STRING)
    private Difficulte difficulte;

    @ManyToMany(mappedBy = "matieres", cascade = CascadeType.PERSIST)
    private List<Formateur> formateurs;

    /**
     * Constructeur vide
     */
    public Matiere() {}

    /**
     * Constructeur sans id
     * @param nom String
     * @param duree String
     * @param difficulte String
     * @param formateurs List<Formateur>
     */
    public Matiere(String nom, String duree, Difficulte difficulte, List<Formateur> formateurs) {
        this.nom = nom;
        this.duree = duree;
        this.difficulte = difficulte;
        this.formateurs = formateurs;
    }

    /**
     * Constructeur avec id
     * @param id Long
     * @param nom String
     * @param duree String
     * @param difficulte String
     * @param formateurs List<Formateur>
     */
    public Matiere(Long id, String nom, String duree, Difficulte difficulte, List<Formateur> formateurs) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
        this.difficulte = difficulte;
        this.formateurs = formateurs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
    }

    public List<Formateur> getFormateurs() {
        return formateurs;
    }

    public void setFormateurs(List<Formateur> formateurs) {
        this.formateurs = formateurs;
    }
}
