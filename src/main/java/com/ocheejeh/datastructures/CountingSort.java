package com.ocheejeh.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountingSort {
    public static void main(String[] args) {
        List<Integer> countingSortList =  countingSort(List.of(4, 6, 1, 3));

        System.out.println(countingSort(countingSortList));
    }
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] itemFreq = new int[100];
        for(int i = 0; i<arr.size(); i++){
            increaseItemFreq(itemFreq, arr.get(i));
        }
        System.out.println("Item frequencies array is: " + Arrays.toString(itemFreq));
        List<Integer> itemFrequencies = new ArrayList<>(100);
//        for (int i = 0; i < itemFreq.length; i++) {
//            itemFrequencies.add(itemFreq[i]);
//        }
        // convert primitive array to the equivalent wrapper array e.g. int[] to Integer[]
        itemFrequencies = Arrays.stream(itemFreq).boxed().collect(Collectors.toList());
        return itemFrequencies;
    }
    public static void increaseItemFreq( int[] itemFreq, int  item){
        ++itemFreq[item];
    }
}
