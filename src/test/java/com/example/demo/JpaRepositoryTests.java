package com.example.demo;

import com.example.demo.dao.AdresseRepository;
import com.example.demo.dao.PersonneRepository;
import com.example.demo.model.Adresse;
import com.example.demo.model.Personne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaRepositoryTests {
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private AdresseRepository adresseRepository;

    @Test
    void testFindByNom() {
        personneRepository.findAllByNom("Doe").forEach(System.out::println);
    }

    @Test
    void testManyToOne() {
        Adresse adresse = new Adresse("rue de la Mairie", 12, "Paris");
        adresseRepository.save(adresse);

        Personne personne = new Personne("Alain", "Dupond");
        personne.setAdresse(adresse);
        personneRepository.save(personne);
    }
}
