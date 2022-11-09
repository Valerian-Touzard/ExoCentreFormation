package com.example.centreformation.Services;

import com.example.centreformation.Entities.Stagiaire;
import com.example.centreformation.Repositories.StagiaireRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StagiaireService {
    @Autowired
    private StagiaireRepoJPA stagiaireRepoJPA;

    /**
     * Fonction qui retourne la liste complète des stagiaires
     * @return list<Stagiaire>
     */
    public List<Stagiaire> findAll(){
        return this.stagiaireRepoJPA.findAll();
    }

    /**
     * Fonction qui retourne un stagiaire via son id
     * @param id Long
     * @return Stagiaire
     */
    public Stagiaire findById(Long id){
        Optional<Stagiaire> optStagiaire = this.stagiaireRepoJPA.findById(id);
        if (optStagiaire.isPresent()){
            return optStagiaire.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Fonction qui insère un nouvelle objet Stagiaire dans la BDD
     * @param stagiaire
     * @return Stagiaire
     */
    public Stagiaire create(Stagiaire stagiaire){
        return this.stagiaireRepoJPA.save(stagiaire);
    }


    /**
     * Fonction qui modifie un stagaire dans la BDD
     * @param stagiaire
     * @return Stagiaire
     */
    public Stagiaire update(Stagiaire stagiaire){
        if (!this.stagiaireRepoJPA.existsById(stagiaire.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Le stagiaire à mettre à jour n'éxiste pas");
        }else {
            return this.stagiaireRepoJPA.save(stagiaire);
        }
    }

    /**
     * Fonction qui supprime un stagaire en BDD
     * @param id Long
     * @return Stagiaire
     */
    public Stagiaire delete(Long id){
        if (!this.stagiaireRepoJPA.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de trouver le stagiaire à supprimer");
        }
        Stagiaire stagiaireDel = this.findById(id);
        this.stagiaireRepoJPA.deleteById(id);
        if(this.stagiaireRepoJPA.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Erreur lors de la suppression du stagiaire: "+id);
        }

        return stagiaireDel;
    }
}
