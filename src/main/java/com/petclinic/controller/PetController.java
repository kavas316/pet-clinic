package com.petclinic.controller;


import com.petclinic.repository.PetsRepository;
import com.petclinic.service.PetsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetController {

    private PetsService petsService;

    public PetController(PetsService petsService){
        this.petsService = petsService;
    }

    @GetMapping("/list")
    public String viewAllPets(Model model){
        model.addAttribute("listPet"+"s",petsService.getAllPets());
        return "pets";
    }


}
