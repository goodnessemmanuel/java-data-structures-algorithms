package com.ocheejeh.datastructures;

public class SelectionSort {
    static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return;
    }

    static int indexOfMinimum(int[] array, int startIndex) {
        int minValue = array[startIndex];
        int minIndex = startIndex;

        for(int i = minIndex + 1; i < array.length; i++) {
            if(array[i] < minValue) {
                minIndex = i;
                minValue = array[i];

            }
        }
        return minIndex;
    };

    public static void selectionSort(int[] array) {
        // Write this method
        for (int i = 0;  i < array.length; i++){
            int minIndex = indexOfMinimum(array, i);
            if(minIndex != i){
                swap(array, i, minIndex);
            }
        }
        return;
    }
}
