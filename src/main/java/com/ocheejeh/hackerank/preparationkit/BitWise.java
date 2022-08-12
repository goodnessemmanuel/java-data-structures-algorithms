package com.ocheejeh.hackerank.preparationkit;

import java.util.logging.Logger;

public class BitWise {

    /**
     *  flip demo
     *  5 (= 0101 ) padded to 32bits you get 0000 0000 0000 0000 0000 0000 0101
     *  in binary, when flipped, you get 1111 1111 1111 1111 1111 1111 1010.
     *  this is achieved by casting to int data type first(i.e. 32bits)
     *  followed by using the bitwise compliment operator (e.g. ~5)
     *  The result is now converted to decimal as a long with
     *  Integer.toUnsignedLong to give corresponding long value
     * @param v long value whose bits is to be flipped and
     *         the corresponding result converted back to decimal
     * @return the result of the flipped value in decimal
     */
    public static long flipIn32Bits(long v){
        Logger log = Logger.getAnonymousLogger();
        int n = (int)v; // casting to int to ensure operation is in 32bits
        String bin = Integer.toBinaryString(~n);
        String logMessage = String.format("input value: %d when flipped in binary is: %s", v, bin);
        log.info(logMessage);

        long result = Integer.toUnsignedLong(~n);
        logMessage = String.format("input value: %d when flipped in binary, then passed as unsigned long: %s", v, result);
        log.info(logMessage);

        return result;
    }

    /**
     * how this operation works:
     * - converts a (e.g. 5) to the binary equivalent (e.g. 0101)
     * - converts b (e.g. 6) to the binary equivalent (e.g. 0110)
     * - performs 'OR' operation as in (e.g. 0101 | 0110 = 0111)
     * - converts and returns the result of the decimal equivalent
     * e.g. 0111 => 7 (in decimal)
     * @param a first operand
     * @param b second operand
     * @return resulting OR operation
     */
    public static int doOR(int a, int b){
        return a | b;
    }
}
