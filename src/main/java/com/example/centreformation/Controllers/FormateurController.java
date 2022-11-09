package com.example.centreformation.Controllers;

import com.example.centreformation.Entities.Formateur;
import com.example.centreformation.Services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/formateurs")
public class FormateurController {
    @Autowired
    private FormateurService formateurService;

    /**
     * Appelle le service pour récupérer la liste des formateurs
     * @return List(Formateur)
     */
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Formateur> findAll(){
        return this.formateurService.findAll();
    }

    /**
     * Appelle le service pour récupérer un formateur vie son id
     * @param id Long
     * @return Formateur
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Formateur findById(@PathVariable Long id){
        return this.formateurService.findById(id);
    }

    /**
     * Appelle le service pour insérer un formateur dans la BDD
     * @param formateur
     * @return Formateur
     */
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Formateur create(@RequestBody Formateur formateur){
        return this.formateurService.create(formateur);
    }

    /**
     * Appelle le service pour modifier un formateur dans la BDD via son id
     * @param formateur Formateur
     * @param id Long
     * @return Formateur
     */
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Formateur update(Formateur formateur, @PathVariable Long id){
        if (!id.equals(formateur.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formateur inconue");
        }
        return this.formateurService.update(formateur);
    }

    /**
     * Appelle le service pour supprimer un formateur dans la BDD via son id
     * @param id Long
     * @return Formateur
     */
    @ResponseStatus(HttpStatus.GONE)
    @DeleteMapping("/{id}")
    public Formateur delete(@PathVariable Long id){
        return this.formateurService.delete(id);
    }


}
