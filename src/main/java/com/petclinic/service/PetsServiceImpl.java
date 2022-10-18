package com.petclinic.service;


import com.petclinic.model.Owner;
import com.petclinic.model.Pets;
import com.petclinic.repository.PetsRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Component
public class PetsServiceImpl implements PetsService {

    private PetsRepository petsRepository;

    public PetsServiceImpl(PetsRepository petsRepository){
        this.petsRepository = petsRepository;
    }

    public List<Pets> findByKeyword(String keyword){
        return petsRepository.findByKeyword(keyword);
    }

    public List<Pets> getAllPets(){
        return petsRepository.findAll();
    }

    public void savePet(Pets pets){
        this.petsRepository.save(pets);
    }

    public void deletePet(int id){
        this.petsRepository.deleteById(id);
    }

    public Pets getPetById(int id){
        Optional<Pets> optional = petsRepository.findById(id);
        Pets pet = null;
        if(optional.isPresent()){
            pet = optional.get();
        }else{
            throw new RuntimeException("Pet is Not Found");
        }
        return pet;
    }

}
