package com.example.centreformation.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "adresse")
public class Adresse {
    @Id
    @GeneratedValue
    private Long id;
    private Integer numero;
    private String rue;
    private Integer codePostale;
    private String ville;
    private String pays;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Formateur> formateurs;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Stagiaire> stagiaires;

    /**
     * Constructeur vide
     */
    public Adresse() {}

    /**
     * Constructeur sans id
     * @param numero Integer
     * @param rue String
     * @param codePostale Integer
     * @param ville String
     * @param pays String
     * @param formateurs List<Formateur>
     * @param stagiaires List<Stagiaire>
     */
    public Adresse(Integer numero, String rue, Integer codePostale, String ville, String pays, List<Formateur> formateurs, List<Stagiaire> stagiaires) {
        this.numero = numero;
        this.rue = rue;
        this.codePostale = codePostale;
        this.ville = ville;
        this.pays = pays;
        this.formateurs = formateurs;
        this.stagiaires = stagiaires;
    }

    /**
     * Constructeur avec id
     * @param id Long
     * @param numero Integer
     * @param rue String
     * @param codePostale Integer
     * @param ville String
     * @param pays String
     * @param formateurs List<Formateur>
     * @param stagiaires List<Stagiaire>
     */
    public Adresse(Long id, Integer numero, String rue, Integer codePostale, String ville, String pays, List<Formateur> formateurs, List<Stagiaire> stagiaires) {
        this.id = id;
        this.numero = numero;
        this.rue = rue;
        this.codePostale = codePostale;
        this.ville = ville;
        this.pays = pays;
        this.formateurs = formateurs;
        this.stagiaires = stagiaires;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(Integer codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<Formateur> getFormateurs() {
        return formateurs;
    }

    public void setFormateurs(List<Formateur> formateurs) {
        this.formateurs = formateurs;
    }

    public List<Stagiaire> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
    }
}
