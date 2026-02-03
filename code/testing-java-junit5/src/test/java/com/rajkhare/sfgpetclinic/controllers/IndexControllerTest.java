package com.rajkhare.sfgpetclinic.controllers;

import com.rajkhare.sfgpetclinic.exceptions.ValueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @DisplayName("Test exception")
    @Test
    void oupsHandler() {

        assertThrows(ValueNotFoundException.class, () -> {
            indexController.oopsHandler();
        });

    }

    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("I got from assertTimeOut");
        });
    }

    @Test
    void testTimePreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("I got from assertTimePreemptively");
        });
    }
}