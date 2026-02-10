package com.rajkhare.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Sia", "Khare");
        owner.setCity("Hyderabad");
        owner.setTelephone("5432154321");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Sia", owner.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Khare", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Hyderabad", owner.getCity(), "City Did Not Match"),
                        () -> assertEquals("5432154321", owner.getTelephone())
                ));

        assertThat(owner.getCity(), is("Hyderabad"));

    }
}