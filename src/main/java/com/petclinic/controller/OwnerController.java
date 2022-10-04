package com.petclinic.controller;

import com.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    }







