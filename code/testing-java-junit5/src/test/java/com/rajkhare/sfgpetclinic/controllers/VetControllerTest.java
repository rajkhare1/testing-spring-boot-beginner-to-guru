package com.rajkhare.sfgpetclinic.controllers;

import com.rajkhare.sfgpetclinic.fauxspring.Model;
import com.rajkhare.sfgpetclinic.fauxspring.ModelMapImpl;
import com.rajkhare.sfgpetclinic.services.SpecialtyService;
import com.rajkhare.sfgpetclinic.services.VetService;
import com.rajkhare.sfgpetclinic.services.map.SpecialityMapService;
import com.rajkhare.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VetControllerTest {

    VetService vetService;
    SpecialtyService specialtyService;

    VetController vetController;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();

        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);
    }
}