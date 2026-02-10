package com.rajkhare.sfgpetclinic.controllers;

import com.rajkhare.sfgpetclinic.exceptions.ValueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(),"Wrong view returned");

        assertEquals("index", indexController.index(),() -> "Another Expensive Message " +
                "Make me only if you have to");

        assertThat(indexController.index()).isEqualTo("index");
    }

    @DisplayName("Test exception")
    @Test
    void oupsHandler() {

        assertThrows(ValueNotFoundException.class, () -> {
            indexController.oopsHandler();
        });

    }

    @Disabled("Disabled timeout test")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got from assertTimeOut");
        });
    }

    @Disabled("Disabled timeout test")
    @Test
    void testTimePreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got from assertTimePreemptively");
        });
    }

    @Test
    void testAssumptionTrue() {

        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {

        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
        
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_17)
    @Test
    void testMeOnJava17() {
    }

    @EnabledOnJre(JRE.JAVA_21)
    @Test
    void testMeOnJava21() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "rajkhare")
    @Test
    void testIfUserRajKhare() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "jt")
    @Test
    void testIfUserJt() {
    }
}