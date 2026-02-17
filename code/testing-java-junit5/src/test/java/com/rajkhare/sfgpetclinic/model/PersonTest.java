package com.rajkhare.sfgpetclinic.model;

import com.rajkhare.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

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