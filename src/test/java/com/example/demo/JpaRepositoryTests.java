package com.example.demo;

import com.example.demo.dao.AdresseRepository;
import com.example.demo.dao.ChienRepository;
import com.example.demo.dao.PersonneRepository;
import com.example.demo.dao.StageRepository;
import com.example.demo.model.Adresse;
import com.example.demo.model.Chien;
import com.example.demo.model.Personne;
import com.example.demo.model.Stage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class JpaRepositoryTests {
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private AdresseRepository adresseRepository;
    @Autowired
    private StageRepository stageRepository;
    @Autowired
    private ChienRepository chienRepository;

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

    @Test
    void testManyToMany() {
        Personne p1 = new Personne("Alain", "Dupond");
        personneRepository.save(p1);
        Personne p2 = new Personne("Marie", "Durand");
        personneRepository.save(p2);
        Personne p3 = new Personne("Said", "Dupond");
        personneRepository.save(p3);

        Stage stageJava = new Stage("Java", "pour débutants");
        stageJava.addStagiaire(p1);
        stageJava.addStagiaire(p2);
        stageRepository.save(stageJava);

        Stage stageSQL = new Stage("SQL", "pour admins");
        stageSQL.addStagiaire(p2);
        stageSQL.addStagiaire(p3);
        stageRepository.save(stageSQL);
    }

    @Test
    void testOneToMany() {
        Chien ch1 = new Chien("Tommy", 9);
        chienRepository.save(ch1);
        Chien ch2 = new Chien("Frank", 5);
        chienRepository.save(ch2);

        Personne p1 = new Personne("Alain", "Dupond");
        p1.addChien(ch1);
        p1.addChien(ch2);
        personneRepository.save(p1);

    }

    @Test
    void testLectureChiens() {
        Optional<Personne> op = personneRepository.findById(10);

        if(op.isPresent()) {
            Personne p = op.get();
            p.getChiens().forEach(c -> System.out.println(c.getNom()));
        }
    }
}
