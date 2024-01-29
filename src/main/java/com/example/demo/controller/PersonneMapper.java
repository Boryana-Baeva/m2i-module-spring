package com.example.demo.controller;

import com.example.demo.model.Personne;

public class PersonneMapper {
    public static PersonneDTO convertEntityToDTO(Personne entity) {
        PersonneDTO dto = new PersonneDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getPrenom());
        dto.setLastName(entity.getNom());

        return dto;
    }

    public static Personne convertDTOToEntity(PersonneDTO dto) {
        Personne entity = new Personne();
        entity.setId(dto.getId());
        entity.setPrenom(dto.getFirstName());
        entity.setNom(dto.getLastName());

        return entity;
    }
}
