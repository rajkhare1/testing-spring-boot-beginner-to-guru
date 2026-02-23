package com.rajkhare.sfgpetclinic.model;

import com.rajkhare.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

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

    @DisplayName("Value Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Raj"})
    void testValueSource(String val) {
        System.out.println(val);
    }
}