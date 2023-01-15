package com.ocheejeh.hackerank.certification.algorithms;

import javax.swing.text.Segment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Week3 {

    public static void main(String[] args) {
        // test number of segment, birthday challenge

        //int n = birthdayNumberOfWayBarCanBeDivided(List.of(2, 2, 1, 3, 2), 4, 2);
        //int n = birthdayNumberOfWayBarCanBeDivided(List.of(1, 2, 1, 3, 2), 3, 2);

        //System.out.println("number of segements is: " + n);

        //week3MockTest1(new ArrayList<>(Arrays.asList(2, 6)), new ArrayList<>(Arrays.asList(24, 36)));
//       int factorCount = week3MockTest(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(100)));
//        int factor2Count = week3MockTestCorrectApproach(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(100)));
       int factorCount = week3MockTest(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(96, 48)));
        int factor2Count = week3MockTestCorrectApproach(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(96, 48)));
        System.out.println();
    }

    /**
     * Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
     *
     * Lily decides to share a contiguous segment of the bar selected such that:
     *
     * The length of the segment matches Ron's birth month, and,
     * The sum of the integers on the squares is equal to his birth day.
     * Determine how many ways she can divide the chocolate.
     *
     * Example
     *[2 2 1 3 2], d = 4, m =2;
     *
     *
     * Lily wants to find segments summing to Ron's birth day, d =4  with a length equalling his birth month, m =2.
     * In this case, there are two segments meeting her criteria: [2 2] and [1 3].
     *
     * Function Description
     *
     * Complete the birthday function in the editor below.
     *
     * birthday has the following parameter(s):
     *
     * int s[n]: the numbers on each of the squares of chocolate
     * int d: Ron's birth day
     * int m: Ron's birth month
     * Returns
     *
     * int: the number of ways the bar can be divided
     * @return
     */
    private static int birthdayNumberOfWayBarCanBeDivided(List<Integer> s, int d, int m){
        int numOfWays = 0;
        for (int i = 0; i < s.size(); i++) {
            List<Integer> segment = getSegment(s, s.get(i), i, d, m);
            if(sum(segment) == d && segment.size() == m)
                numOfWays++;
        }
        return numOfWays;

    }

    private static List<Integer> getSegment(List<Integer> arr, int day, int month, int startIndex){
        List<Integer> segment = new ArrayList<>(month);
        int k = startIndex;
        while (segment.size() < month && k < arr.size() && sum(segment) < day){
            segment.add(arr.get(k));
            k++;
        }
        return segment;

    }
    private static List<Integer> getSegment(List<Integer> arr, int currentItem, int currentItemIndex, int day, int month){
        List<Integer> segment = new ArrayList<>(month);
        segment.add(currentItem);
        int j = 1;
        for (int i = currentItemIndex + 1; j <= month && i < arr.size() && sum(segment) < day; j++, i++) {
            segment.add(arr.get(i));
        }
        return segment;

    }
    private static int sum(List<Integer> arr){
        int sum = 0;
        for (Integer n: arr) {
            sum += n;
        }
        return sum;
    }

    private static int week3MockTest(List<Integer> a, List<Integer> b){
        Collections.sort(b);
        int smallestEle = b.get(0);
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= smallestEle; i+=2) {
            if(smallestEle % i == 0) factors.add(i);
        }
        factors =  factors.stream()
               .filter(n -> b.stream().allMatch(m -> m % n == 0))
                .filter(n -> a.stream().allMatch(m -> n >= m && n % m == 0))
               .collect(Collectors.toList());

        return factors.size();
    }

    private static int week3MockTestCorrectApproach(List<Integer> a, List<Integer> b){
        Collections.sort(b);
        int smallestEle = b.get(0);
        List<Integer> factors = IntStream.rangeClosed(1, smallestEle/2).boxed().filter(i -> smallestEle % i == 0).collect(Collectors.toList());
       factors.add(smallestEle);

       factors = factors.stream().filter(f -> b.stream().allMatch(i -> i % f == 0))
               .filter(i -> a.stream().allMatch(j -> i % j == 0))
               .collect(Collectors.toList());

        return factors.size();
    }
}
