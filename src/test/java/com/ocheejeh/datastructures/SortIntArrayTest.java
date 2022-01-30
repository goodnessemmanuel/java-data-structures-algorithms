package com.ocheejeh.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortIntArrayTest {

    @Test
    public void shouldProperlySortIntegersInDescendingOrder(){

        int[] test1 = {1, 2, 4, 3, 5, 7};
        int[] expected1 = {7, 5, 4, 3, 2, 1};
        int[] actual1 = SortIntArray.sortIntArrayDescendingOrder(test1);

        int[] test2 = {10, 89, 15, 16, 17, 50, 0, 1, 5, 14};
        int[] expected2 = {89, 50, 17, 16, 15, 14, 10, 5, 1, 0};
        int[] actual2 = SortIntArray.sortIntArrayDescendingOrder(test2);

        int[] test3 = {50, 10, 89, 89, 15, 16, 17, 50, 0, 1, 1, 5, 14};
        int[] expected3 = {89, 89, 50, 50, 17, 16, 15, 14, 10, 5, 1, 1, 0};
        int[] actual3 = SortIntArray.sortIntArrayDescendingOrder(test3);

        assertAll(
                () -> assertArrayEquals(expected1, actual1, "Should sort according to step difference"),
                () -> assertArrayEquals(expected2, actual2, "Large integer value should sort correctly"),
                () -> assertArrayEquals(expected3, actual3, "duplicate ints should be retained in the correct order")
        );
    }
}