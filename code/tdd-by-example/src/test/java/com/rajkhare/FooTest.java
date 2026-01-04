package com.rajkhare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {

    @Test
    void getChai() {
        Foo foo = new Foo();
        String result = foo.getChai();
        assertEquals("FooChai", result);
    }
}