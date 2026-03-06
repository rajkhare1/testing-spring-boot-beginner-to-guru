package com.rajkhare.sfgpetclinic.model;

import com.rajkhare.sfgpetclinic.CustomArgsProvider;
import com.rajkhare.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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

    @DisplayName("Enum Source Test")
    @ParameterizedTest
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType type) {
        System.out.println(type);
    }

    @DisplayName("CSV Input Test")
    @ParameterizedTest
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 3, 1"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName +" = "+val1+" : "+val2);
    }

    @DisplayName("CSV From File Test")
    @ParameterizedTest
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFileInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName +" = "+val1+":"+val2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest
    @MethodSource("getArgs")
    void formMethodProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName +" = "+val1+":"+val2);
    }

    @DisplayName("Custom Provider Test")
    @ParameterizedTest
    @ArgumentsSource(CustomArgsProvider.class)
    void formCustomProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName +" = "+val1+":"+val2);
    }


    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("FL", 5, 1),
                           Arguments.of("OH", 2, 8),
                           Arguments.of("MI", 3, 5)
        );
    }

}