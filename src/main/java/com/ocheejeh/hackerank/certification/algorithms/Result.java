package com.ocheejeh.hackerank.certification.algorithms;

import java.util.Locale;

public class Result {

    public static void main(String[] args) {
        /*int countValey = countingValleys(4, "DDUU");
        System.out.println(countValey);*/

        //String s = "The quick brown fox jumps over a lazy dog";
        String s = "We promptly judged antique ivory buckles for the prize";
        System.out.println(pangrams(s));
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int valleys = 0;
        int height = 0;
        for (int i = 0; i < steps; i++) {
            if (height == -1 && path.charAt(i) == 'U') valleys++;
            if (path.charAt(i) == 'U') height++;
            if (path.charAt(i) == 'D') height--;
        }

        return valleys;

    }

    public static String pangrams(String s){
        if(isPangrams(s)){
            return "pangrams";
        }
        return "not pangrams";
    }
    public static boolean isPangrams(String s){
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        s = s.toLowerCase();
        for (int i = 0; i < alphabets.length(); i++) {
            if(!s.contains(String.valueOf(alphabets.charAt(i))))
                return false;
        }

        return true;
    }


}
