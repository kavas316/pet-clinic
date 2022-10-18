package com.petclinic.controller;


import com.petclinic.model.Owner;
import com.petclinic.model.Pets;
import com.petclinic.repository.OwnerRepository;
import com.petclinic.repository.PetsRepository;
import com.petclinic.service.PetsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetController {

    private PetsService petsService;

    private OwnerRepository ownerRepository;

    public PetController(PetsService petsService,OwnerRepository ownerRepository){

        this.petsService = petsService;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/list")
    public String viewAllPets(Model model,String keyword){

        if(keyword != null){
            model.addAttribute("listPet"+"s",petsService.findByKeyword(keyword));

        }
        else{
            model.addAttribute("listPet"+"s",petsService.getAllPets());
        }
        return "pets";
    }

    @GetMapping("/new")
    public String newPet(Model model){
        Pets pet= new Pets();
        List<Owner> listOwners = ownerRepository.findAll();
        model.addAttribute("pet",pet);
        model.addAttribute("listOwner"+"s",listOwners);
        return "new_pet";
    }

    @PostMapping("/savePet")
    public String savePet(@ModelAttribute("pet")Pets pet){
        petsService.savePet(pet);
        return "redirect:/pets/list";
    }
    @GetMapping("/updatePet/{id}")
    public String updatePet(@PathVariable(name ="id")int id, Model model){
        Pets pet = petsService.getPetById(id);
        List<Owner> listOwners = ownerRepository.findAll();
        model.addAttribute("listOwner"+"s",listOwners);
        model.addAttribute("pets",pet);
        return "update_pet";
    }

    @GetMapping("/deletePet/{id}")
    public String deleteOwner(@PathVariable(name = "id")int id){
        Pets pet = petsService.getPetById(id);
        if(pet != null){
            pet.setOwner(null);
            this.petsService.deletePet(id);
        }else{
            return "redirect:/pets/list";
        }

        return "redirect:/pets/list";
    }

}
