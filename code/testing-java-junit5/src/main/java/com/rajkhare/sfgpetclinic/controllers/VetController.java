package com.rajkhare.sfgpetclinic.controllers;

import com.rajkhare.sfgpetclinic.fauxspring.Model;
import com.rajkhare.sfgpetclinic.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}