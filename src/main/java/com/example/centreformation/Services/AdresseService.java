package com.example.centreformation.Services;

import com.example.centreformation.Entities.Adresse;
import com.example.centreformation.Repositories.AdresseRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseService {
    @Autowired
    private AdresseRepoJPA adresseRepoJPA;

    /**
     * Fonction qui retourne la liste complète des adresses
     * @return list<Adresse>
     */
    public List<Adresse> findAll(){
        return this.adresseRepoJPA.findAll();
    }

    /**
     * Fonction qui retourne une adresse via son id
     * @param id Long
     * @return Adresse
     */
    public Adresse findById(Long id){
        Optional<Adresse> optStagiaire = this.adresseRepoJPA.findById(id);
        if (optStagiaire.isPresent()){
            return optStagiaire.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Fonction qui insère un nouvelle objet Adresse dans la BDD
     * @param adresse
     * @return Adresse
     */
    public Adresse create(Adresse adresse){
        return this.adresseRepoJPA.save(adresse);
    }


    /**
     * Fonction qui modifie une adresse dans la BDD
     * @param adresse
     * @return Stagiaire
     */
    public Adresse update(Adresse adresse){
        if (!this.adresseRepoJPA.existsById(adresse.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"L'adresse à mettre à jour n'éxiste pas");
        }else {
            return this.adresseRepoJPA.save(adresse);
        }
    }

    /**
     * Fonction qui supprime une adresse en BDD
     * @param id Long
     * @return Adresse
     */
    public Adresse delete(Long id){
        if (!this.adresseRepoJPA.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de trouver l'adresse à supprimer");
        }
        Adresse adresseDel = this.findById(id);
        this.adresseRepoJPA.deleteById(id);
        if(this.adresseRepoJPA.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Erreur lors de la suppression de l'adresse: "+id);
        }

        return adresseDel;
    }
}
