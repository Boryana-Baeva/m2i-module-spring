package com.example.demo.controller;

import com.example.demo.model.Personne;
import com.example.demo.service.Annuaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api")
@RestController
public class PersonneController {
    @Autowired
    private Annuaire annuaire;

    // GET /personnes
    @GetMapping("personnes")
    public List<Personne> getPersonnes() {
        return annuaire.getAll();
    }

    // POST /personnes
    @PostMapping("personnes")
    public ResponseEntity<?> addPersonne(@RequestBody Personne newPersonne) {
        System.out.println(newPersonne);

        if(newPersonne.getNom().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Le nom est obligatoire !");
        }
        else {
            annuaire.add(newPersonne);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPersonne);
        }

    }

    // GET /personnes/4
    @GetMapping("personnes/{id}")
    public ResponseEntity<Personne> getById(@PathVariable Integer id) {
        Personne personne = annuaire.findById(id);
        if(personne == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(personne);
        }
    }

    // DELETE /personnes/4
    @DeleteMapping("personnes/{id}")
    public void delete(@PathVariable("id") Integer id) {
        annuaire.delete(id);
    }

    // PUT /personnes/4
    @PutMapping("personnes/{id}")
    public void update(@RequestBody Personne personne, @PathVariable Integer id) {
        annuaire.update(id, personne);
    }
}
