package com.ocheejeh.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MathChallenge {
    private final static int FIX_NUM = 6174;
    private static int count = 0;
    public static int mathChallenge(int num) {
        // code goes here
        String numStr = num + "";
        //pad the number if it's not upto 4 digit
        while(numStr.length() < 4){
            numStr = "0".concat(numStr);
        }
        String[] splitNum = numStr.split("");
        Integer [] splitNumInt = new Integer[splitNum.length];
        for(int i =0; i < splitNum.length; i++){
            splitNumInt[i] = Integer.parseInt(splitNum[i]);
        }
        Integer[] ascending = Arrays.copyOf(splitNumInt, splitNumInt.length);
        Arrays.sort(ascending);
        Integer[] descending = Arrays.copyOf(ascending, ascending.length);
        List<Integer> integers = Arrays.asList(descending);
        integers.sort(Collections.reverseOrder());
        descending = integers.toArray(descending);
        String ascendingStr = "";
        String descendingStr = "";
        for (int i = 0; i < ascending.length; i++) {
            ascendingStr = ascendingStr.concat(ascending[i] + "");
            descendingStr = descendingStr.concat(descending[i] + "");
        }

        int numAscending = Integer.parseInt(ascendingStr);
        int numDescending = Integer.parseInt(descendingStr);
        int diff = numDescending -  numAscending;
        count++;
        System.out.printf("%d - %d = %d%n", numDescending, numAscending, diff);
        if(diff == FIX_NUM){
            return count;
        }
        return mathChallenge(diff);
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a 4 digit number of choice: ");
        System.out.print(mathChallenge(Integer.parseInt(s.nextLine())));

    }

}
