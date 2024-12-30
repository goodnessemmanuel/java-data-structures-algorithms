package com.ocheejeh.turing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TuringChallenge {
    public static void main(String[] args) {
        /*int[] k1 = new int[]{1,2,2,3,1};
        int[] k2 = new int[]{1,2,2,3,1,4,2};
        int[] k3 = new int[]{1,2,3,4,5};
        int[] k4 = new int[]{4, 5};
        int[] k5 = new int[]{1, 1, 2, 2, 4, 5, 4, 2, 4, 4, 1, 4, 1, 1, 6, 4};
        System.out.println("Smallest possible length of the sub array, k1 is: "+ degreeOfAnArray(k1));
        System.out.println("Smallest possible length of the sub array, k2 is: "+ degreeOfAnArray(k2));
        System.out.println("Smallest possible length of the sub array, k2 is: "+ degreeOfAnArray(k3));
        System.out.println("Smallest possible length of the sub array, k2 is: "+ degreeOfAnArray(k4));
        System.out.println("Smallest possible length of the sub array, k2 is: "+ degreeOfAnArray(k5));*/

       /* System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"})); //ouputs: 30
        System.out.println(calPoints(new String[]{"1"})); //outputs: 1
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));*/
        System.out.println(test(new int[]{2, 7, 4, 1, 8, 1}));
    }

    /**
     * The weight of an array is defined as the maximum number of occurrence of any integer in the array.
     * Given an array of positive integers k. find the smallest length of a subarray k that has
     * the same weight as k
     * Example:
     * [1,2,2,3,1] output = 2
     * [1,2,2,3,1,4,2] output = 6;
     * @param k
     * @return
     * Note: Turing use java8
     */
    public static int degreeOfAnArray(int[] k){
        //get the highest integer occurrence
        int kLen = k.length;
        List<Integer> kList = new ArrayList<>();
        for (int i = 0; i < kLen; i++) {
            kList.add(k[i]);
        }
        int highestOccurredInt = 0;
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < kLen; i++) {
            if(visited.contains(kList.get(i))) continue;
            int currentHighestOccurrence = getOccurrence(i, kList);
            visited.add(k[i]);
            if (currentHighestOccurrence > highestOccurredInt)
                highestOccurredInt = currentHighestOccurrence;
        }

        return getSmallestPossibleSubArrayLength(k, highestOccurredInt, highestOccurredInt);
    }

    /**
     * build subarray with length that begins
     * from the highestOccurredInt to k length
     * check which sub array has same weight with
     * parent array k. and return then length or -1
     * return the
     * @param k
     * @param highestRepeatedIntCount
     * @param targetSubArrayLen
     * @return
     */
    public static int getSmallestPossibleSubArrayLength(int [] k, int highestRepeatedIntCount, int targetSubArrayLen){
        int kLen = k.length;
        if(targetSubArrayLen >= kLen) return -1;
        for (int i = 0; i < kLen; i++) {
            List<Integer> subArray = new ArrayList<>();
            subArray.add(k[i]);
            for (int m = i + 1; m < kLen; m++) {
                if(subArray.size() == targetSubArrayLen) break;
                subArray.add(k[m]);
            }

            List<Integer>  visited = new ArrayList<>();
            for (int j = 0; j < subArray.size(); j++) {
                if(visited.contains(subArray.get(j))) continue;
                int subArrayHighestOccurredInt = getOccurrence(j, subArray);
                if(subArrayHighestOccurredInt == highestRepeatedIntCount) return targetSubArrayLen;
                visited.add(subArray.get(j));

            }
        }
        return getSmallestPossibleSubArrayLength(k, highestRepeatedIntCount, ++targetSubArrayLen);
    }
    private static int getOccurrence(int i, List<Integer> k) {
        int item = k.get(i);
        int count = 0;
        for (Integer value : k) {
            if (item == value) count++;
        }
        return count;
    }

    // baseball game
    public static int calPoints(String[] ops){
        int result = Integer.MIN_VALUE;
        List<Integer> scores = new ArrayList<>();
        for(int i = 0; i < ops.length; i++){
            switch (ops[i]){
                case "+" :
                    int prevSum = scores.get(scores.size() - 1) + scores.get(scores.size() - 2);
                    scores.add(prevSum);
                break;
                case "D" :
                    int prevMul = scores.get(scores.size() - 1) * 2;
                    scores.add(prevMul);
                break;
                case "C" :
                    scores.remove(scores.size() - 1);
                break;
                default:
                    scores.add(Integer.valueOf(ops[i]));
            }
        }

        int sum = 0;
        for (Integer n : scores) {
            sum += n;
        }

        return  sum;
    }


/*
    public static int degreeOfAnArrayWithoutRecursion(int[] k){
        //get the highest integer occurrence
        int kLen = k.length;
        List<Integer> kList = new ArrayList<>();
        for (int i = 0; i < kLen; i++) {
            kList.add(k[i]);
        }
        int highestOccurredInt = 0;
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < kLen; i++) {
            if(visited.contains(kList.get(i))) continue;
            int currentHighestOccurrence = getOccurrence(i, kList);
            visited.add(k[i]);
            if (currentHighestOccurrence > highestOccurredInt)
                highestOccurredInt = currentHighestOccurrence;
        }
        visited.clear();
        *//**
         * start building subarray with length that begins
         * from the highestOccurredInt to k length
         *//*
        for (int j = highestOccurredInt; j < kLen; j++) {
            for (int i = 0; i < kLen; i++) {
                List<Integer> subArray = new ArrayList<>();
                subArray.add(k[i]);
                for (int m = i + 1; m < k.length; m++) {
                    if(subArray.size() == j) break;
                    subArray.add(k[m]);
                }

                visited = new ArrayList<>();
                for (int l = 0; l < subArray.size(); l++) {
                    if(visited.contains(subArray.get(l))) continue;
                    int subArrayHighestOccurredInt = getOccurrence(l, subArray);
                    if(subArrayHighestOccurredInt == highestOccurredInt) return j;
                    visited.add(subArray.get(l));

                }
            }
        }

        return -1;
    }
    */

    public static int test(int[] k){
        List<Integer> y = new ArrayList<>();
        for (Integer m: k){
            y.add(m);
        }
        while (y.size() > 1){
            y = getFight(y);
        }

        return y.get(0);
    }

    private static List<Integer> getFight(List<Integer> y) {
        Collections.sort(y);
        if(y.size() > 1){
            int highest = y.get(y.size() - 1);
            int secondHighest = y.get(y.size() - 2);
            int diff = highest - secondHighest;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < y.size() - 2; i++) {
                list.add(y.get(i));
            }
            if(diff > 0){
                list.add(diff);
            }
            return list;
        }else {
            return y;
        }
    }

    public static void play(){

    }

}
