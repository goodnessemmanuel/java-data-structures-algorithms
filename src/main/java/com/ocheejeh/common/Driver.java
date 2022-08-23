package com.ocheejeh.common;

public class Driver {
    public static void main(String[] args) {
        System.out.println("\ntotal steps: " +findSteps(3));
//        System.out.println(findSteps(4));
//        System.out.println(findSteps(5));
    }

    /**
     * @param n
     * @return number of ways to climb steps
     * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
     * Implement a method to count how many possible ways the child can run up the stairs.
     *
     * Examples:
     *
     * Input : 4
     * Output : 7
     * Explanation:
     * Below are the seven ways
     *  1 step + 1 step + 1 step + 1 step
     *  1 step + 2 step + 1 step
     *  2 step + 1 step + 1 step
     *  1 step + 1 step + 2 step
     *  2 step + 2 step
     *  3 step + 1 step
     *  1 step + 3 step
     *
     * Input : 3
     * Output : 4
     * Explanation:
     * Below are the four ways
     *  1 step + 1 step + 1 step
     *  1 step + 2 step
     *  2 step + 1 step
     *  3 step
     *
     *
     */
    public static long findSteps(long n){
        if(n < 0) return 0;
        if(n == 0 ) return 1;
        long res3 = findSteps(n - 3);
        System.out.printf("n-3 call result: %d%n", res3);
        long res2 = findSteps(n - 2);
        System.out.printf("n-2 call result: %d%n", res2);
        long res1 = findSteps(n - 1);
        System.out.printf("n-1 call result: %d%n", res1);
        long sumSteps = res1 + res2 + res3;
        System.out.printf("sum steps for all 3 calls is: %d%n", sumSteps);
        return sumSteps;
    }
}
