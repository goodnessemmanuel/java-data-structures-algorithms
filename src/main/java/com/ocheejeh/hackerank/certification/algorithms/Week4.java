package com.ocheejeh.hackerank.certification.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Week4 {

    /**
     * Given an array of integers, find the longest subarray where the absolute difference between any two elements is less than or equal to .
     *
     * Example
     * a = [1, 1 , 2, 2, 4, 4, 5, 5, 5] there are two subarrays meeting the criterion
     *
     * There are two subarrays meeting the criterion: [1, 1, 2, 2] and [4, 4, 5, 5, 5]. The maximum length subarray has 5  elements.
     *
     * Function Description
     *
     * Complete the pickingNumbers function in the editor below.
     *
     * pickingNumbers has the following parameter(s):
     *
     * int a[n]: an array of integers
     * Returns
     *
     * int: the length of the longest subarray that meets the criterion
     */
    public static void main(String[] args) {
//        int test = pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1));
//        System.out.println("max length is: " +test);
//        separateNumbers2("1234");
//        separateNumbersMath("1234"); //outputs "YES 1" bcos 2-1 = 3-2 = 4-3
//        separateNumbersMath("99100");
//        separateNumbersMath("91011");
//        separateNumbersMath("9899100");
//        separateNumbersMath("99910001001");
        separateNumbersMath("999100010001");
        separateNumbersMath("858687888990919293949596979899");
        separateNumbersMath("858687888990919293949596979898");
        separateNumbersMath("998999100010011902100310041005");
        separateNumbersMath("998999100010011002100310041005");
        separateNumbersMath("979899100101102103104105106107");
        separateNumbersMath("1234567891011120314151617181920");
        separateNumbersMath("1234567891011121314151617181920");

        System.out.println();
       /* separateNumbersMath("429496729542949672964294967297");
        separateNumbersMath("429496729542949672964294967296");
        separateNumbersMath("429496729542949672964294967287");
        separateNumbersMath("429496729542949672964294967197");
        separateNumbersMath("42949672954294967296429496729");
        separateNumbersMath("4294967295429496729642949672");
        separateNumbersMath("429496729500000000000000000001");
        separateNumbersMath("42949672950123456789");
        separateNumbersMath("4294967295000010020030000456789");
        separateNumbersMath("4294967295000102003004005");*/
//        separateNumbersMath("65666768697071727374757677787980");
//        separateNumbersMath("65666768697071727374757677787970");
//        separateNumbersMath("24252627282930313233343536373739");
        /*separateNumbersMath("10");*/
        separateNumbersMath("4545");
        //separateNumbersMath("010203");
//        separateNumbersMath("13");
        //separateNumbersMath("4");
//        separateNumbersMath("33");
//        separateNumbersMath("4445");

    }


    public static int pickingNumbers(List<Integer> a) {
        if(isNotSorted(a)) Collections.sort(a);
        List<List<Integer>> subArrays = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            List<Integer> sub = getPickedNumbers(i, a);
            subArrays.add(sub);
            i = i + sub.size()-1;
        }
        if(subArrays.size() == 1) return subArrays.get(0).size();
        int maxLen = 0;
        for (List<Integer> list : subArrays) {
            maxLen = Math.max(maxLen, list.size());
        }

        return maxLen;
    }
    public static List<Integer> getPickedNumbers(int i, List<Integer> a){
        List<Integer> numbers = new ArrayList<>();
        int num = a.get(i);
        numbers.add(num);
        for (int j = i + 1; j < a.size(); j++) {
            if(isValid(numbers, a.get(j))) {
                numbers.add(a.get(j));
            }
        }
        return numbers;
    }
    public static boolean isNotSorted(List<Integer> a){
        return IntStream.range(0, a.size() - 1).anyMatch(i -> a.get(i) > a.get(i + 1));
    }
    public static boolean isValid(List<Integer> k, int n){
        return IntStream.range(0, k.size()).noneMatch(i -> Math.abs(n - k.get(i)) > 1);
    }

    /**
     * A numeric string, s, is beautiful if it can be split into a sequence of two or more positive integers, a[1], a[2], a[3]... a[n] , satisfying the following conditions:
     *  a[i] - a[i - 1] = 1
     *  for any  1 < i <= n (i.e., each element in the sequence is 1 more than the previous element).
     * No  contains a leading zero. For example, we can split {10203} into the sequence {1, 02, 03 }, but it is not beautiful because  02 and 03 have leading zeroes.
     * The contents of the sequence cannot be rearranged. For example, we can split s = 312  into the sequence {3, 1, 2}, but it is not beautiful because it breaks our first constraint (i.e., 1-3 != 1 ).
     * @param s
     */

    public static void separateNumbersMath(String s){
        // a beautiful number is in such that, x1, 1 + x1, 2 + x1, n + Xn => x2 = 1 + x1, etc
        StringBuilder sb = new StringBuilder();
        int sLen = s.length();
        for (int i = 0; i < sLen/2 && s.charAt(0) != '0'; i++) {
            List<Long> nums = new ArrayList<>();
            sb.append(s.charAt(i));
            long item1 = Long.parseLong(sb.toString());
            nums.add(item1);
            int len = sb.length();

            if(len < sLen && s.charAt(len) != '0') {
                StringBuilder bd = new StringBuilder(len + 1);
                for (int j = len; j < s.length(); j++) {
                    bd.append(s.charAt(j));
                    long current = Long.parseLong(bd.toString());
                    int k = nums.size();
                    if((bd.length() == 1 && bd.charAt(0) == '0') || (j == sLen - 1 && current < k + item1) || current > k + item1) {
                        nums.clear();
                        break;
                    }

                    if (current == k + item1) {
                        nums.add(current);
                        bd = new StringBuilder(len + 1);
                    }
                }
            }
            if ( nums.size() > 1 ) {
                System.out.println("YES " + nums.get(0));
                return;
            }
        }
        System.out.println("NO");
    }


}
