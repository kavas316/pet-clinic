package com.petclinic.service;

import com.petclinic.model.Pets;

import java.util.List;

public interface PetsService {

    List<Pets> getAllPets();

    void savePet(Pets pets);

    void deletePet(int id);

    Pets getPetById(int id);
}
