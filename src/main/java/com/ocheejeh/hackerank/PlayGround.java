package com.ocheejeh.hackerank;

import com.ocheejeh.hackerank.preparationkit.BitWise;

public class PlayGround {
    public static void main(String[] args) {
        int n = 5;

        int k = BitWise.doOR(n, 6);
        System.out.printf("bitwise OR of %d, %d is: %d %n", n, 6, k);
        long testFlip = BitWise.flipIn32Bits(4);
        System.out.println(testFlip);
    }

}
