package com.ocheejeh.hackerank;

import com.ocheejeh.hackerank.preparationkit.BitWise;

import java.util.ArrayList;
import java.util.List;

public class PlayGround {
    public static void main(String[] args) {
        int n = 5;

        /*int k = BitWise.doOR(n, 6);
        System.out.printf("bitwise OR of %d, %d is: %d %n", n, 6, k);
        long testFlip = BitWise.flipIn32Bits(4);
        System.out.println(testFlip);*/
        List<List<Integer>> integerList = new ArrayList<>();
//        11 2 4
//        4 5 6
//        10 8 -12
        integerList.add(List.of(11, 2, 4));
        integerList.add(List.of(4, 5, 6));
        integerList.add(List.of(10, 8, -12));

        int diagonalDiff = diagonalDifference(integerList);
        System.out.println("diagonal difference is: " + diagonalDiff);
    }



    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        List<Integer> posDiag = new ArrayList<>();
        List<Integer> negDiag = new ArrayList<>();
        int posDiagSum = 0, negDiagSum = 0;
        int j = arr.size() - 1;
        for (int i = 0; i < arr.size(); i++) {
            posDiag.add(arr.get(i).get(i));
            posDiagSum += arr.get(i).get(i);
            negDiag.add(arr.get(i).get(j));
            negDiagSum += arr.get(i).get(j);
            j--;
        }

        return Math.abs(posDiagSum - negDiagSum);

    }

}
