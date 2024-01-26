package com.example.demo.controller;

import com.example.demo.model.Personne;
import com.example.demo.service.Annuaire;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api")
@RestController
public class PersonneController {
    private Annuaire annuaire = new Annuaire();

    // GET /personnes
    @GetMapping("personnes")
    public List<Personne> getPersonnes() {
        return annuaire.getAll();
    }

    // POST /personnes
    @PostMapping("personnes")
    public void addPersonne(@RequestBody Personne newPersonne) {
        System.out.println(newPersonne);
        annuaire.add(newPersonne);
    }

    // GET /personnes/4
    @GetMapping("personnes/{id}")
    public Personne getById(@PathVariable Integer id) {
        return annuaire.findById(id);
    }
}
