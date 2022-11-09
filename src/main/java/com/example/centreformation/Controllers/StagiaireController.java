package com.example.centreformation.Controllers;

import com.example.centreformation.Entities.Stagiaire;
import com.example.centreformation.Services.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/stagiaires")
public class StagiaireController {
    @Autowired
    private StagiaireService stagiaireService;

    /**
     * Appelle le service pour récupérer la liste des Stagiaires
     * @return List(Stagiaire)
     */
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Stagiaire> findAll(){
        return this.stagiaireService.findAll();
    }

    /**
     * Appelle le service pour récupérer un stagiaire vie son id
     * @param id Long
     * @return Stagiaire
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Stagiaire findById(@PathVariable Long id){
        return this.stagiaireService.findById(id);
    }

    /**
     * Appelle le service pour insérer un stagiaire dans la BDD
     * @param stagiaire
     * @return Stagiaire
     */
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Stagiaire create(@RequestBody Stagiaire stagiaire){
        return this.stagiaireService.create(stagiaire);
    }

    /**
     * Appelle le service pour modifier un stagiaire dans la BDD via son id
     * @param stagiaire Stagiaire
     * @param id Long
     * @return Stagiaire
     */
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Stagiaire update(Stagiaire stagiaire, @PathVariable Long id){
        if (!id.equals(stagiaire.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stagiaire inconue");
        }
        return this.stagiaireService.update(stagiaire);
    }

    /**
     * Appelle le service pour supprimer un stagiaire dans la BDD via son id
     * @param id Long
     * @return Stagiaire
     */
    @ResponseStatus(HttpStatus.GONE)
    @DeleteMapping("/{id}")
    public Stagiaire delete(@PathVariable Long id){
        return this.stagiaireService.delete(id);
    }
}
