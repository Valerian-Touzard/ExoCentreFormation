package com.example.centreformation.Controllers;

import com.example.centreformation.Entities.Adresse;
import com.example.centreformation.Entities.Matiere;
import com.example.centreformation.Services.AdresseService;
import com.example.centreformation.Services.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/matiere")
public class MatiereController {
    @Autowired
    private MatiereService matiereService;

    /**
     * Appelle le service pour récupérer la liste des matières
     * @return List(Matières)
     */
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Matiere> findAll(){
        return this.matiereService.findAll();
    }

    /**
     * Appelle le service pour récupérer une matière via son id
     * @param id Long
     * @return Matiere
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Matiere findById(@PathVariable Long id){
        return this.matiereService.findById(id);
    }

    /**
     * Appelle le service pour insérer une matières dans la BDD
     * @param matiere
     * @return Matiere
     */
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Matiere create(@RequestBody Matiere matiere){
        return this.matiereService.create(matiere);
    }

    /**
     * Appelle le service pour modifier une matiere dans la BDD via son id
     * @param matiere Matiere
     * @param id Long
     * @return Matiere
     */
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Matiere update(Matiere matiere, @PathVariable Long id){
        if (!id.equals(matiere.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "matiere inconue");
        }
        return this.matiereService.update(matiere);
    }

    /**
     * Appelle le service pour supprimer une matiere dans la BDD via son id
     * @param id Long
     * @return Matiere
     */
    @ResponseStatus(HttpStatus.GONE)
    @DeleteMapping("/{id}")
    public Matiere delete(@PathVariable Long id){
        return this.matiereService.delete(id);
    }
}
