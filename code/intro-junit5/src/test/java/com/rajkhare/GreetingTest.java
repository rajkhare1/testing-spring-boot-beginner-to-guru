package com.rajkhare;

import org.junit.jupiter.api.*;


class GreetingTest {

   private Greeting greeting;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before - I am only called once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());
    }

    @Test
    void testHelloWorldName() {
        System.out.println(greeting.helloWorld("Raj"));
    }

    @Test
    void testHelloWorldName2() {
        System.out.println(greeting.helloWorld("Sia"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("In After Each...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After - I am only called once");
    }
}