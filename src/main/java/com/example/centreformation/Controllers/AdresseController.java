package com.example.centreformation.Controllers;

import com.example.centreformation.Entities.Adresse;
import com.example.centreformation.Services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/adresses")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    /**
     * Appelle le service pour récupérer la liste des adresses
     * @return List(Adresse)
     */
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Adresse> findAll(){
        return this.adresseService.findAll();
    }

    /**
     * Appelle le service pour récupérer une adresse vie son id
     * @param id Long
     * @return Adresse
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Adresse findById(@PathVariable Long id){
        return this.adresseService.findById(id);
    }

    /**
     * Appelle le service pour insérer une adresse dans la BDD
     * @param adresse
     * @return Adresse
     */
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Adresse create(@RequestBody Adresse adresse){
        return this.adresseService.create(adresse);
    }

    /**
     * Appelle le service pour modifier une adresse dans la BDD via son id
     * @param adresse Adresse
     * @param id Long
     * @return Adresse
     */
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Adresse update(Adresse adresse, @PathVariable Long id){
        if (!id.equals(adresse.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "adresse inconue");
        }
        return this.adresseService.update(adresse);
    }

    /**
     * Appelle le service pour supprimer une Adresse dans la BDD via son id
     * @param id Long
     * @return Adresse
     */
    @ResponseStatus(HttpStatus.GONE)
    @DeleteMapping("/{id}")
    public Adresse delete(@PathVariable Long id){
        return this.adresseService.delete(id);
    }
}
