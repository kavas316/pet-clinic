package com.petclinic.controller;

import com.petclinic.model.Owner;
import com.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService){this.ownerService  = ownerService;}

    @GetMapping("/list")
    public String viewHomePage(Model model){
        model.addAttribute("listOwner"+"s",ownerService.getAllOwners());
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

    @GetMapping("/updateOwner")
    public String updateOwner(@PathVariable(name ="id")int id, Model model){
        Owner owner = ownerService.getOwnerById(id);
        model.addAttribute("owner",owner);
        return "update_owner";
    }

    @DeleteMapping("/deleteOwner/{id}")
    public String deleteOwner(@PathVariable(name = "id")int id){
        this.ownerService.deleteOwner(id);
        return "redirect:/";
    }
    }







