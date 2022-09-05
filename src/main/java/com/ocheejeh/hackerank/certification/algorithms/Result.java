package com.ocheejeh.hackerank.certification.algorithms;

import java.util.*;

public class Result {

    public static void main(String[] args) {
        /*int countValey = countingValleys(4, "DDUU");
        System.out.println(countValey);*/

        //String s = "The quick brown fox jumps over a lazy dog";
        String s = "We promptly judged antique ivory buckles for the prize";
        //System.out.println(pangrams(s));

        System.out.println(solution("nndNfdfdf"));

        long [] nums = new long[]{2, 45, 6};
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * Given a string, s, find the length of the longest substring that contains no repeated characters.
     *
     * Example input:
     *
     * s: "nndNfdfdf"
     * Example Output:
     *
     * 4
     * Explanation:
     *
     * "ndNf" is the longest substring within "nndNfdfdf" that contains no repeated characters,
     * and its length is 4 characters.
     * @param s
     * @return
     */
    public static long solution(String s) {
        // Type your solution here
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < s.length(); end++){
            char currentChar = s.charAt(end);
            if(visited.containsKey(currentChar)){
                start = Math.max(visited.get(currentChar) + 1, start);

            }
            if(output.length() < (end - start + 1)){
                output = s.substring(start, end + 1);
            }
            visited.put(currentChar, end);

        }
        System.out.println("Output string is: " + output);
        return Integer.toUnsignedLong(output.length());
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

   /**

            *

            * Complete the 'balancedSum' function below.

            *

            * The function is expected to return an INTEGER. The function accepts

* INTEGER_ARRAY arr as parameter.

            */

    public static int balancedSum(List<Integer> arr) {

// looping from i=1 to arr.size()-2

        for (int i = 1; i < arr.size() - 1; i++) {

// checking if sum of elements between 0 and i-1 is equal to sum

// between i+1 and the end

            if (sum(arr, 0, i - 1) == sum(arr, i + 1, arr.size() - 1)) {

// returning i

                return i;

            }

        }

// just in case if we don't find the solution, returning -1

        return -1;

    }

// private helper method to find the sum of values on a list in the given

// range: start - end (inclusive)

    private static int sum(List<Integer> arr, int start, int end) {

        int s = 0;

// looping and finding sum of values between start and end indices

        for (int i = start; i <= end; i++) {

            s += arr.get(i);

        }

        return s;

    }



}
