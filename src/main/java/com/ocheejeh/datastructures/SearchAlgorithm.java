package com.ocheejeh.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchAlgorithm {

    /**
     *
     * @param items array of integers
     * @param target item you are to search for in the array
     * @return the index of the first occurrence of the target item
     * time complexity is O(n)
     */
    public int linearSearch(int[] items, int target){
        for (int i = 0; i < items.length; i++)
            if(target == items[i]) return i;
        return -1;
    }


    /**
     *
     * @param sortedItems array of integers
     * @param target item you are to search for in the array
     * @return the index of the first occurrence of the target item
     * time complexity is log(n)
     */
    public int binarySearch(int[] sortedItems, int target) {
        int firstIndex = 0;
        int lastIndex = sortedItems.length - 1;
        int middleIndex =  sortedItems.length / 2;

        while (firstIndex <= lastIndex){
            if(target > sortedItems[middleIndex])
                firstIndex = middleIndex + 1;

            if(target < sortedItems[middleIndex])
                lastIndex = middleIndex;

            if( target == sortedItems[middleIndex])
                return middleIndex;

            middleIndex = (firstIndex + lastIndex) / 2;
        }
        return  -1;
    }

    public boolean binarySearchRecursion(int[] sortedItems, int target){

        if(sortedItems.length == 0)
            return false;

        List<Integer> sortedItemsList = Arrays.stream(sortedItems).boxed().collect(Collectors.toList());
        int middleIndex = (sortedItemsList.size()) / 2;


        if(target < sortedItemsList.get(middleIndex)) {
            sortedItemsList = sortedItemsList.subList(0, middleIndex);
            middleIndex = (sortedItemsList.size() ) / 2;
        }

        if(target > sortedItemsList.get(middleIndex)) {
            sortedItemsList = sortedItemsList.subList(middleIndex + 1, sortedItemsList.size());
            middleIndex = (sortedItemsList.size() ) / 2;
        }

        sortedItems = new int[middleIndex];
        Arrays.setAll(sortedItems, sortedItemsList::get);

        if (target == sortedItemsList.get(middleIndex)) return true;

        return binarySearchRecursion(sortedItems, target);
    }

}
