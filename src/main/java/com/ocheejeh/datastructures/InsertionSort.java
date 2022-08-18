package com.ocheejeh.datastructures;

import java.util.Arrays;

/**
 * Implements insert function which will be taking three parameters as inputs: array, rightIndex, and value.
 *
 * Explanation:#
 * Before the insert function is called:
 *
 * the elements from array[0] to array[rightIndex] are sorted in ascending order.
 * the value is in the array at an index from array[rightIndex] to array[end].
 * After calling the insert function:
 *
 * the value from the array is removed from its original position and it is then inserted between array[0] to array[rightIndex+1], maintaining the ascending order.
 * In order to do this, the insert function will need to make room for value by moving items that are greater than value to the right. It should start at rightIndex,
 * and stop when it finds an item that is less than or equal to value, or when it reaches the beginning of the array. Once the function has made room for the value,
 * it can write it to the array.
 * Sample Input:#
 * array = [2, 3, 5, 7, 11, 13, 9, 6]
 * rightIndex = 5
 * value = 9
 * Sample Output:#
 * [2, 3, 5, 7, 9, 11, 13, 6]
 *
 */
public class InsertionSort {

    public static void insertionSort(int[] array) {
        //Write this method
        int rightIndex = 1;

        for(int i = 0; i < array.length; i++){
            if(rightIndex < array.length){
                int targetValue = array[rightIndex];
                insert(array, i, targetValue);
                rightIndex++;
            }
        }

        return;
    }
    static void insertfast(int[] array, int rightIndex, int value) {
        int j = rightIndex;
        for(;
            j >= 0 && array[j] > value;
            j--) {
            array[j + 1] = array[j];
        }
        array[j + 1] = value;
    }
    public static void insert(int[] array, int rightIndex, int value) {
        // write this method
        int key = getIndexOfTargetValue(array, rightIndex, value);
        System.out.printf(" value : %d, index : %d", value, key);
        if(key != -1) {
            for (int i = rightIndex; i >= 0 && array[i] > value; i--) {
                array[key] = array[i];
                array[i] = value;
                key = i;
            }
        }

    }
    private static int getIndexOfTargetValue(int[] array, int startIndex, int value){
        for(int i = startIndex; i < array.length; i++){
            if(array[i] == value) return i;
        }
        return -1;
    }
}
