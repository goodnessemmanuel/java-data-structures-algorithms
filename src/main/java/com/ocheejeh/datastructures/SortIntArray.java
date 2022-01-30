package com.ocheejeh.datastructures;

import java.util.Arrays;
import java.util.Scanner;

public class SortIntArray {
    //driver method
    public static void main(String[] args) {
        int[] ints = getIntegers(5);
        printArray(ints);
        int[] sortInts = sortIntArrayDescendingOrder(ints);
        printArray(sortInts);
        printArray(ints);
    }

    private static int[] sortIntArrayDescendingOrder(int[] ints) {
        int[] sortInts = Arrays.copyOf(ints, ints.length); //don't alter the original
        for (int i = 0; i < sortInts.length; i++) {
            int max = sortInts[i];
            for (int j = i + 1; j < sortInts.length; j++) {
                if(max < sortInts[j]){
                    sortInts[i] = sortInts[j];
                    sortInts[j] = max;
                    max = sortInts[i]; //reset max
                }
            }
        }

        return sortInts;

    }

    private static void printArray(int[] intArray) {
        System.out.println("Array items are: ");
        System.out.println(Arrays.toString(intArray));
    }

    private static int[] getIntegers(int numberOfIntegers) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[numberOfIntegers];
        System.out.println("Enter a list of integers to be stored \r");
        for (int i = 0; i < numberOfIntegers; i++) {
            ints[i] = scanner.nextInt();
        }

        return  ints;
    }

}
