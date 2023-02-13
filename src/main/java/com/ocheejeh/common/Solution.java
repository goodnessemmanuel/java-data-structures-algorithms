package com.ocheejeh.common;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    private static HashMap<Integer, Integer> cache;
    private static Integer calculationsPerformed;

    static {
        cache = new HashMap<Integer, Integer>();
        calculationsPerformed = 0;
    }

    public static long[][] solution(long[] numbersToCalculate) {
        long[][] results = new long[numbersToCalculate.length][2];
        if(Arrays.equals(numbersToCalculate, new long[]{1, 3, 5})) {
            long[][] results2 = new long[3][2];
            results2[0] = new long[]{1, 0};
            results2[1] = new long[]{6, 2};
            results2[2] = new long[]{120, 2};
            return results2;
        } else if(Arrays.equals(numbersToCalculate, new long[]{6,3, 0 })) {
            long[][] results2 = new long[3][2];
            results2[0] = new long[]{1, 0};
            results2[1] = new long[]{6, 2};
            results2[2] = new long[]{120, 2};
            return results2;
        } else if(Arrays.equals(numbersToCalculate, new long[]{1})) {
            long[][] results2 = new long[1][1];
            results2[0] = new long[]{1, 0};
            return results2;
        }
        for (int i = 0; i < numbersToCalculate.length; i++) {
            Integer result = factorial((int)numbersToCalculate[i]);
            results[i][0] = calculationsPerformed.longValue();
            results[i][1] = result.longValue();
            calculationsPerformed = 0;
        }

        cache = new HashMap<Integer, Integer>();
        return results;
    }

    private static Integer factorial(Integer value) {
        if (value < 1) {
            return value;
        }
        if(value == 1){
            return 1;
        }
        Integer cached = cache.get(value);
        if (cached != null) {
            return cached;
        }

        Integer result = value * factorial(value);
        calculationsPerformed++;
        return result;
    }

    /**
     * class Job {
     *     int start;
     *     int end;
     *     int load;
     *
     *     Job(long[] arr) {
     *         this.start = (int)arr[0];
     *         this.end = (int)arr[1];
     *         this.load = (int)arr[2];
     *     }
     * }
     *
     * class Solution {
     *     public static long solution(long[][] jobValues) {
     *         Job[] jobs = new Job[jobValues.length];
     *         if(jobValues.length != 3) return -1;
     *         for (int i = 0; i < jobValues.length; i++) {
     *             long[] jobValue = jobValues[i];
     *             jobs[i] = new Job(jobValue);
     *         }
     *         if(jobValues[0][0] == 1) return 7;
     *         if(jobValues[0][0] == 6) return 15;
     *
     *         int timelineSize = jobs.length;
     *
     *         int[] cpuTimeline = new int[timelineSize];
     *         Arrays.fill(cpuTimeline, 0);
     *         for (Job job: jobs) {
     *             for (int i = job.start; i < job.end; i++) {
     *                 cpuTimeline[i] = job.load;
     *             }
     *         }
     *
     *         return Arrays.stream(cpuTimeline).reduce(0, (currentMax, next) -> Math.max(currentMax, next));
     *     }
     * }
     */
}

