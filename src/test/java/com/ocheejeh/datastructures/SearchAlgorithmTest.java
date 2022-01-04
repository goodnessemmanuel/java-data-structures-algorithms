package com.ocheejeh.datastructures;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SearchAlgorithmTest {
    private SearchAlgorithm searchAlgorithm;

    @BeforeEach
    void init(){
        searchAlgorithm = new SearchAlgorithm();
    }

    @Test
    public void testLinearSearch() {
        assertAll(
                () -> assertEquals(3, searchAlgorithm.linearSearch(new int[]{1, 0, 3, 4}, 4),
                        "Should return correct index of 4 in the array"),
                () -> assertEquals(6, searchAlgorithm.linearSearch(new int[]{1, 0, 3, 6, 4, 7,  5}, 5),
                        "Should return correct index of 5 in the array"),

                () -> assertEquals(-1, searchAlgorithm.linearSearch(new int[]{1, 0, 3, 6}, 4),
                        "Should return a negative index when no match is found")

        );
    }

    @Test
    public void testBinarySearch() {
        //the precondition here is that, input array must be sorted
        assertAll(
                () ->  assertEquals(3, searchAlgorithm.binarySearch(new int[]{1, 2, 3, 4}, 4),
                            "Should return correct index of 4 in the array"),
                () -> assertEquals(4, searchAlgorithm.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 5),
                        "Should return correct index of 5 in the array"),
                () -> assertEquals(-1, searchAlgorithm.binarySearch(new int[]{1, 2, 3, 4}, 9),
                        "Should return a -1 when no match was found")

        );
    }

    @Test
    public void testBinarySearchRecursion() {
        //the precondition here is that, input array must be sorted
        assertAll(
                () ->  assertTrue(searchAlgorithm.binarySearchRecursion(new int[]{1, 2, 3, 4}, 4),
                            "Should return true for target item 4 in the array"),
                () -> assertTrue(searchAlgorithm.binarySearchRecursion(new int[]{1, 2, 3, 4, 5, 6, 7}, 5),
                        "Should return true for target item 5 in the array"),
                () -> assertFalse(searchAlgorithm.binarySearchRecursion(new int[]{1, 2, 3, 4}, 9),
                        "Should return false when no match was found")

        );
    }
}