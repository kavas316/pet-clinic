package com.petclinic.controller;

import com.petclinic.model.Owner;
import com.petclinic.model.Pets;
import com.petclinic.repository.OwnerRepository;
import com.petclinic.repository.PetsRepository;
import com.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;
    private PetsRepository petsRepository;

    private OwnerRepository ownerRepository;

    public OwnerController(OwnerService ownerService, PetsRepository petsRepository,OwnerRepository ownerRepository)
    {this.ownerService  = ownerService;
        this.petsRepository = petsRepository;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/list")
    public String viewHomePage(Model model){
        List<Pets> listPets = petsRepository.findAll();
        List<Owner> listOwners1 = ownerRepository.findAll();
        for(Pets pet : listPets){
            if(pet.getOwner() != null){
                model.addAttribute("listOwner"+"s",ownerService.getAllOwners());
                model.addAttribute("pet",pet);
            }else{
                model.addAttribute("listOwner"+"s",ownerService.getAllOwners());
            }
        }


        return "owners";
    }

    @GetMapping("/new")
    public String newOwner(Model model){
        Owner owner = new Owner();
        model.addAttribute("owner",owner);
        return "new_owner";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(@ModelAttribute("owner")Owner owner){
        ownerService.saveOwner(owner);
        return "redirect:/";
    }

    @GetMapping("/updateOwner/{id}")
    public String updateOwner(@PathVariable(name ="id")int id, Model model){
        Owner owner = ownerService.getOwnerById(id);
        model.addAttribute("owner",owner);
        return "update_owner";
    }

    @GetMapping("/deleteOwner/{id}")
    public String deleteOwner(@PathVariable(name = "id")int id){
        this.ownerService.deleteOwner(id);
        return "owners";
    }
    }







