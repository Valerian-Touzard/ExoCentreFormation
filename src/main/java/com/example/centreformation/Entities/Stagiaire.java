package com.example.centreformation.Entities;

import javax.persistence.*;

@Entity
@Table(name = "stagiaire")
public class Stagiaire {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "civilite")
    @Enumerated(EnumType.STRING)
    private Civilite civilite;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "dateNaissance")
    private String dateNaissance;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Formateur formateur;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Adresse adresse;

    /**
     * Constructeur vide
     */
    public Stagiaire() {}

    /**
     * Constructeur sans id
     * @param civilite String
     * @param nom String
     * @param prenom String
     * @param email String
     * @param dateNaissance String
     * @param formateur Formateur
     * @param adresse Adresse
     */
    public Stagiaire(Civilite civilite, String nom, String prenom, String email, String dateNaissance, Formateur formateur, Adresse adresse) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.formateur = formateur;
        this.adresse = adresse;
    }

    /**
     * Constructeur avec id
     * @param id Long
     * @param civilite String
     * @param nom String
     * @param prenom String
     * @param email String
     * @param dateNaissance String
     * @param formateur Formateur
     * @param adresse Adresse
     */
    public Stagiaire(Long id, Civilite civilite, String nom, String prenom, String email, String dateNaissance, Formateur formateur, Adresse adresse) {
        this.id = id;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.formateur = formateur;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
