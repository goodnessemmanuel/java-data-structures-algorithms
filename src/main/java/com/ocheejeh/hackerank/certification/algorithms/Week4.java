package com.ocheejeh.hackerank.certification.algorithms;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
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

       /* System.out.println(Math.subtractExact(4 , 2));
        System.out.println(Math.subtractExact(30 , -20));
        System.out.println(Math.subtractExact(-470 , -520));
        System.out.println(Math.subtractExact(-6461594 ,-7330761));*/
//        System.out.println(closestNumbers(Arrays.asList(5, 2, 3, 4, 1)));
//        System.out.println(closestNumbers(Arrays.asList(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854 )));
//        System.out.println(closestNumbers(Arrays.asList(5, 4, 3, 2)));
//        System.out.println(closestNumbers(Arrays.asList(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470)));
        String s = "1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M";

        System.out.println(caesarCipher(s, 27));

        /*StringBuilder bd = new StringBuilder("ABC");
        int bIndex = bd.indexOf("A");
        System.out.println("B Index is: " + bIndex);
        bd.delete(bIndex, bIndex + 1);
        System.out.println("Builder content is now: " + bd.toString());*/

//        System.out.println("total anagram switch is: " + anagramReplacementCount("aabbbb"));
//        System.out.println("total anagram switch is: " + anagramReplacementCount("xyxy"));
//        System.out.println("total anagram switch is: " + anagramReplacementCount("kpwxyz"));
//        System.out.println("total anagram switch is: " + anagramReplacementCount("abccde"));
//        System.out.println("total anagram switch is: " + anagramReplacementCount("xaxbbbxx"));
//
//        List<Integer> arr = new ArrayList<>(Arrays.asList(100, 200, 300, 350, 400, 401, 402));
//        System.out.println("Min unfair diff: " + maxMin(3, arr));;

        //testing password strength

        System.out.println("weakness level: " + minimumNumber(5, "2bbbb"));
        System.out.println("weakness level: " + minimumNumber(6, "2A%HH0h"));
        System.out.println("weakness level: " + minimumNumber(3, "2bb"));
        System.out.println("weakness level: " + minimumNumber(5, "2bb#A"));
        System.out.println("weakness level: " + minimumNumber(4, "2111"));
        System.out.println("weakness level: " + minimumNumber(4, "aaabbbb2"));
        System.out.println("weakness level: " + minimumNumber(1, "a"));
        System.out.println("weakness level: " + minimumNumber(7, "AUzs-nV"));
      /*  long startTime = System.nanoTime();
        separateNumbersMath("999100010001");
        separateNumbersMath("858687888990919293949596979899");
        separateNumbersMath("858687888990919293949596979898");
        separateNumbersMath("998999100010011902100310041005");
        separateNumbersMath("998999100010011002100310041005");
        separateNumbersMath("979899100101102103104105106107");
        separateNumbersMath("1234567891011120314151617181920");
        separateNumbersMath("1234567891011121314151617181920");
        separateNumbersMath("429496729542949672964294967297");
        separateNumbersMath("429496729542949672964294967296");
        separateNumbersMath("429496729542949672964294967287");
        separateNumbersMath("429496729542949672964294967197");
        separateNumbersMath("42949672954294967296429496729");
        separateNumbersMath("4294967295429496729642949672");
        separateNumbersMath("429496729500000000000000000001");
        separateNumbersMath("42949672950123456789");
        separateNumbersMath("4294967295000010020030000456789");
        separateNumbersMath("4294967295000102003004005");
        System.out.println("Total time taken in nanosecond -> " + (System.nanoTime() - startTime));*/
//        separateNumbersMath("65666768697071727374757677787980");
//        separateNumbersMath("65666768697071727374757677787970");
//        separateNumbersMath("24252627282930313233343536373739");
        /*separateNumbersMath("10");*/
//        separateNumbersMath("4545");
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


    /**
     * Sorting is useful as the first step in many different tasks. The most common task is to make finding things easier, but there are other uses as well.
     * In this case, it will make it easier to determine which pair or pairs of elements have the smallest absolute difference between them.
     *
     * Example arr = [5, 4, 3, 2, 1]
     *
     * Sorted, arr' = [1, 2, 3, 4, 5] . Several pairs have the minimum difference of 1:
     * [(1, 2), (2, 3), (3, 4), (4, 5)]. Return the array [1, 2, 2, 3, 3, 4, 4, 5].
     * @param arr
     * @return
     */
    public static List<Integer> closestNumbers(List<Integer> arr) {
        //sort the collection
        Collections.sort(arr);
        System.out.println("sorted to: " + arr);
        //get min difference
        System.out.println();
        int minDiff =  Math.subtractExact(arr.get(1), arr.get(0));
        System.out.println("Before: minDiff: " + minDiff);
        for (int i = 1; i < arr.size() - 1; i++) {
            int dX = arr.get(i + 1) - arr.get(i);
            if(minDiff > dX){
                minDiff = dX;
            }
        }
        System.out.println("After: minDiff: " + minDiff);

        //use the min difference to filter the array items
        List<Integer> closeIntegers = new ArrayList<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            if(arr.get(i + 1) - arr.get(i) == minDiff) {
                closeIntegers.add(arr.get(i));
                closeIntegers.add(arr.get(i + 1));
            }
        }
        return closeIntegers;
    }

    /**
     * Julius Caesar protected his confidential information by encrypting it using a cipher.
     * Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet,
     * just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
     * @param s
     * @param k
     * @return
     */
    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder builder = new StringBuilder(s.length());
        while(k > 26) {
            k = k % 26;
        }
        for (int i = 0; i < s.length(); i++) {
            int asciiCode = (int)s.charAt(i);
            int rotate = asciiCode;
            if(rotate >= 65 && rotate <= 90){
                rotate = asciiCode + k > 90? asciiCode + k - 26 : asciiCode + k;
            } else if(rotate >= 97 && rotate <= 122) {
                rotate = asciiCode + k > 122? asciiCode + k - 26 : asciiCode + k;
            }
            char ch = (char)rotate;
            builder.append(ch);
        }
        //old test => 1Y7U4WsDt23l4ww08E6zR3T19H4sWQ188N9bivyC6k1uNH[t1n10fz7fVk62XW2fyMU4D83{m7R80N
        //System.out.println("ciphered string rotated by " + k + " is: " + builder.toString());
        return builder.toString();
    }

    public static int anagramReplacementCount(String s){
        int len = s.length();
        if(len % 2 != 0) return -1;
        String s1 = s.substring(0, len/2);
        String s2 = s.substring(len/2, len);
        StringBuilder s1Wrapper = new StringBuilder(s1);

        int c = 0;
        for (int i = 0; i < len/2; i++) {
            int charIndexInS1 = s1Wrapper.indexOf(s2.charAt(i) + "");
            if(charIndexInS1 != -1){
                s1Wrapper.delete(charIndexInS1, charIndexInS1 + 1);
            } else {
                c++;
            }
        }

        return c;
    }

    /**
     *
     * @param k
     * @param arr
     * @return
     * You will be given a list of integers, arr, and a single integer k.
     * You must create an array of length k from elements of  such that its unfairness is minimized.
     * Call that array arr'. Unfairness of an array is calculated as max(arr') - min(arr')
     *
     * Where:
     * - max denotes the largest integer in arr
     * - min denotes the smallest integer in arr'
     *
     * Example
     * arr = [1,4, 7, 2], k = 2
     * Pick any two elements, say [4, 7].
     * unfairness = max(4, 7) - min(4,7) = 7 - 4 = 3
     *
     * Testing for all pairs, the solution [1, 2] provides the minimum unfairness. (i.e. 2 - 1 = 1)
     *
     */

    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int minUnfair = Integer.MAX_VALUE;
        int len = arr.size();
        for (int i = 0; i < len; i++) {
            int nextIndex = i + k - 1;
            if( nextIndex < len ) {
                int currentMinFair = arr.get(nextIndex) - arr.get(i);
                if(minUnfair > currentMinFair) {
                    minUnfair = currentMinFair;
                    if(minUnfair == 0) return 0;
                }
            }
        }
        return minUnfair;
    }

    /**
     * Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password. However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:
     *
     * Its length is at least 6.
     * It contains at least one digit.
     * It contains at least one lowercase English character.
     * It contains at least one uppercase English character.
     * It contains at least one special character. The special characters [!@#$%^&*()-+ ]
     * Example
     * "2bbbb" = 2 strength needed of type Uppercase and special case
     *  2bb#A = 1 strength needed, length is less than 6
     * @param n
     * @param password
     * @return
     */
    public static int minimumNumber(int n, String password) {
        Arrays.toString(new int[3]);
        int weekNessLevel = 0;
        if(!password.matches(".*[a-z].*")){
            weekNessLevel++;
        }
        if(!password.matches(".*[A-Z].*")){
            weekNessLevel++;
        }
        if(!password.matches(".*\\d.*")){
            weekNessLevel++;
        }
        if(!password.matches(".*[!@#$%^&*()\\-+].*")){
            weekNessLevel++;
        }

        //return Math.max(6-n, weekNessLevel);

        if(n < 6){
            int less = 6 - n;
            if(weekNessLevel > less){
                return less + (weekNessLevel - less);
            } else {
                return  less;
            }
        }
        return weekNessLevel;

    }

}
