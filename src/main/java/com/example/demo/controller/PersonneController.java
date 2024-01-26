package com.example.demo.controller;

import com.example.demo.model.Personne;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api")
@RestController
public class PersonneController {
    // GET /personnes
    @GetMapping("personnes")
    public List<Personne> getPersonnes() {
        ArrayList<Personne> personnes = new ArrayList<>();

        personnes.add(new Personne("JS", "Dominguez"));
        personnes.add(new Personne("Yana", "Rault"));

        return personnes;
    }

    // POST /personnes
    @PostMapping("personnes")
    public void addPersonne(@RequestBody Personne newPersonne) {
        System.out.println(newPersonne);
    }
}
