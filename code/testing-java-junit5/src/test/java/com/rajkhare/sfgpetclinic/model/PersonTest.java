package com.rajkhare.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1L, "Raj", "Khare");

        //then
        assertAll("Test Props Set",
                () -> assertEquals("Raj", person.getFirstName()),
                () -> assertEquals("Khare", person.getLastName())
                );
    }

    @Test
    void groupedAssertionsMsgs() {
        //given
        Person person = new Person(1L, "Raj", "Khare");

        //then
        assertAll("Test Props Set",
                () -> assertEquals("Raj", person.getFirstName(), "FirstName failed"),
                () -> assertEquals("Khare", person.getLastName(),"LastName Failed")
        );
    }
}