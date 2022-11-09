package com.example.centreformation.Services;

import com.example.centreformation.Entities.Formateur;
import com.example.centreformation.Repositories.FormateurRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FormateurService {
    @Autowired
    private FormateurRepoJPA formateurRepoJPA;

    /**
     * Fonction qui retourne la liste complète des formateurs
     * @return List<Formateur>
     */
    public List<Formateur> findAll(){
        return this.formateurRepoJPA.findAll();
    }

    /**
     * Fonction qui retourne un formateur via son id
     * @param id Long
     * @return Formateur
     */
    public Formateur findById(Long id){
        Optional<Formateur> optFormateur = this.formateurRepoJPA.findById(id);
        if (optFormateur.isPresent()){
            return optFormateur.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Fonction qui insère un nouvelle objet Formteur dans la BDD
     * @param formateur
     * @return Formateur
     */
    public Formateur create(Formateur formateur){
        return this.formateurRepoJPA.save(formateur);
    }

    /**
     * Fonction qui met à jours un formateur
     * @param formateur
     * @return Formateur
     */
    public Formateur update(Formateur formateur){
        if (!this.formateurRepoJPA.existsById(formateur.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Le formateur à mettre à jour n'éxiste pas");
        }else {
            return this.formateurRepoJPA.save(formateur);
        }
    }

    /**
     * Fonction qui supprime un formateur en bdd
     * @param id Long
     * @return List<Formateur>
     */
    public Formateur delete(Long id){
        if (!this.formateurRepoJPA.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de trouver le formateur à supprimer");
        }
        Formateur formateurDel = this.findById(id);
        this.formateurRepoJPA.deleteById(id);
        if(this.formateurRepoJPA.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Erreur lors de la suppression du formateur: "+id);
        }

        return formateurDel;
    }
}
