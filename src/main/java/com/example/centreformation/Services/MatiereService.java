package com.example.centreformation.Services;

import com.example.centreformation.Entities.Matiere;
import com.example.centreformation.Repositories.MatiereRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService {
    @Autowired
    private MatiereRepoJPA matiereRepoJPA;

    /**
     * Fonction qui retourne la liste complète des matières
     * @return List<Matiere>
     */
    public List<Matiere> findAll(){
        return this.matiereRepoJPA.findAll();
    }

    /**
     * Fonction qui retourne une matière via son id
     * @param id Long
     * @return Matiere
     */
    public Matiere findById(Long id){
        Optional<Matiere> optMatiere = this.matiereRepoJPA.findById(id);
        if (optMatiere.isPresent()){
            return optMatiere.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Fonction qui insère un nouvelle objet Formteur dans la BDD
     * @param matiere
     * @return Matiere
     */
    public Matiere create(Matiere matiere){
        return this.matiereRepoJPA.save(matiere);
    }

    /**
     * Fonction qui met à jours un matière
     * @param matiere
     * @return Matiere
     */
    public Matiere update(Matiere matiere){
        if (!this.matiereRepoJPA.existsById(matiere.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Le matière à mettre à jour n'éxiste pas");
        }else {
            return this.matiereRepoJPA.save(matiere);
        }
    }

    /**
     * Fonction qui supprime un matière en bdd
     * @param id Long
     * @return List<Matière>
     */
    public Matiere delete(Long id){
        if (!this.matiereRepoJPA.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de trouver le matière à supprimer");
        }
        Matiere matiereDel = this.findById(id);
        this.matiereRepoJPA.deleteById(id);
        if(this.matiereRepoJPA.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Erreur lors de la suppression du matière: "+id);
        }

        return matiereDel;
    }
}
