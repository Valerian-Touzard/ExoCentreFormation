package com.example.centreformation.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "formateur")
public class Formateur {
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
    @Column(name = "dateEmbauche")
    private String dateEmbauche;
    @Column(name = "niveauExperience")
    private String niveauExperience;
    @Column(name = "statusInterne")
    private Boolean statusInterne;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Adresse adresse;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Stagiaire stagiaire;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "matiere_formateur",
            joinColumns = @JoinColumn(name = "formateur_id"),
            inverseJoinColumns = @JoinColumn(name = "matiere_id")
    )
    private List<Matiere> matieres;
    /**
     * Constructeur vide
     */
    public Formateur() {}

    /**
     * Constructeur sans id
     * @param civilite String
     * @param nom String
     * @param prenom String
     * @param email String
     * @param dateEmbauche String
     * @param niveauExperience String
     * @param statusInterne Boolean
     * @param adresse Adresse
     * @param matieres List<Matiere>
     */
    public Formateur(Civilite civilite, String nom, String prenom, String email, String dateEmbauche, String niveauExperience, Boolean statusInterne, Adresse adresse, List<Matiere> matieres, Stagiaire stagiaire) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateEmbauche = dateEmbauche;
        this.niveauExperience = niveauExperience;
        this.statusInterne = statusInterne;
        this.adresse = adresse;
        this.matieres = matieres;
        this.stagiaire = stagiaire;
    }

    /**
     * Constructeur avec id
     * @param id Long
     * @param civilite String
     * @param nom String
     * @param prenom String
     * @param email String
     * @param dateEmbauche String
     * @param niveauExperience String
     * @param statusInterne Boolean
     * @param adresse Adresse
     * @param matieres List<Matiere>
     */
    public Formateur(Long id, Civilite civilite, String nom, String prenom, String email, String dateEmbauche, String niveauExperience, Boolean statusInterne, Adresse adresse, List<Matiere> matieres, Stagiaire stagiaire) {
        this.id = id;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateEmbauche = dateEmbauche;
        this.niveauExperience = niveauExperience;
        this.statusInterne = statusInterne;
        this.adresse = adresse;
        this.matieres = matieres;
        this.stagiaire = stagiaire;
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

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getNiveauExperience() {
        return niveauExperience;
    }

    public void setNiveauExperience(String niveauExperience) {
        this.niveauExperience = niveauExperience;
    }

    public Boolean getStatusInterne() {
        return statusInterne;
    }

    public void setStatusInterne(Boolean statusInterne) {
        this.statusInterne = statusInterne;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }
}
