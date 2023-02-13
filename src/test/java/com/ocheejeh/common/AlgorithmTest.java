package com.ocheejeh.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class AlgorithmTest {

    @Test
    @DisplayName("Test for balanced bracket")
    void shouldCheckIfBalancedBracket(){
        String actual = Algorithm.balancedBracket("{}");
        String actual1 = Algorithm.balancedBracket("([{{[(())]}}])");
        String actual2 = Algorithm.balancedBracket("{[()]}");
        String actual3 = Algorithm.balancedBracket("abc[](){}");
        String actual4 = Algorithm.balancedBracket("{[(])}");
        String actual5 = Algorithm.balancedBracket("{{[]()}}}}");
        assertAll(
                () -> assertEquals("valid", actual, "test 1"),
                () -> assertEquals("valid", actual1, "test 2"),
                () -> assertEquals("valid", actual2, "test 3"),
                () -> assertEquals("invalid", actual3, "test 4"),
                () -> assertEquals("invalid", actual4, "test 5"),
                () -> assertEquals("invalid", actual5, "test 6")
        );
    }

    @Test
    @DisplayName("Test for balanced bracket")
    void shouldCheckIfBalancedBracketDeque(){

        String actual = Algorithm.balancedBracketWithDeque("{}");
        String actual1 = Algorithm.balancedBracketWithDeque("([{{[(())]}}])");
        String actual2 = Algorithm.balancedBracketWithDeque("{[()]}");
        String actual3 = Algorithm.balancedBracketWithDeque("abc[](){}");
        String actual4 = Algorithm.balancedBracketWithDeque("{[(])}");
        String actual5 = Algorithm.balancedBracketWithDeque("{{[]()}}}}");

        assertAll(
                () -> assertEquals("valid", actual, "test 1"),
                () -> assertEquals("valid", actual1, "test 2"),
                () -> assertEquals("valid", actual2, "test 3"),
                () -> assertEquals("invalid", actual3, "test 4"),
                () -> assertEquals("invalid", actual4, "test 5"),
                () -> assertEquals("invalid", actual5, "test 6")
        );
    }

    @Test
    void shouldCorrectlyDecodeMorseSignal(){
        List<String> expected = List.of("E", "T");
        List<String> actual = Algorithm.decodeMorseCode("?");
        List<String> expected1 = List.of("I", "N");
        List<String> actual1 = Algorithm.decodeMorseCode("?.");
        List<String> expected2 = List.of("I", "A");
        List<String> actual2 = Algorithm.decodeMorseCode(".?");

        List<String> actual3 = Algorithm.decodeMorseCode("?..");
        System.out.println(actual3);
        assertEquals(expected2, actual2);
    }
}