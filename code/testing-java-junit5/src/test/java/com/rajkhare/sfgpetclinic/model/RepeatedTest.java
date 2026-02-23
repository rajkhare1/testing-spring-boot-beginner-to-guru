package com.rajkhare.sfgpetclinic.model;

import com.rajkhare.sfgpetclinic.services.BeforeEachByDefaultForRepeatedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatedTest implements BeforeEachByDefaultForRepeatedTest {

    @org.junit.jupiter.api.RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {
        //todo - impl
    }

    @org.junit.jupiter.api.RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName()+": "+repetitionInfo.getCurrentRepetition()+"-"+testInfo.getTestClass());
    }

    @org.junit.jupiter.api.RepeatedTest(4)
    @DisplayName("Assignment Test")
    void newRepeatedTestForAssignment() {
    }
}
