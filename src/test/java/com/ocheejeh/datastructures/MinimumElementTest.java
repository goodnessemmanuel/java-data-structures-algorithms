package com.ocheejeh.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumElementTest {

    @Test
    void shouldFindTheMinimumElement() {
        int[] test1 = {2, 3, 4, 1, 10, 12};
        int expect1 = 1;
        int actual1 = MinimumElement.findMin(test1);

        int[] test2 = {0, 3, 0, 1, 10, 12, 33};
        int expect2 = 0;
        int actual2 = MinimumElement.findMin(test2);

        assertEquals(expect1, actual1, "Should return the min element in the array");
        assertEquals(expect2, actual2, "Should return the min element in the array");
    }
}