package com.ocheejeh.leetcode;
/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

public class TwoSumIndices {
    /**
     * Driver function
     * @param args
     */
    public static void main(String[] args) {
        System.out.println();
    }
    public static int[] twoSum(int[] nums, int target) {
        //int[] numIndices = new int[] {-1, -1};

        //edge case
        // if(nums.length < 2 || nums.length > 1000){
        //     return null;
        // }

        //if(target < -100000000 || target > 1000000000) return null;

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length;  j++){
                if(nums[i] + nums[j] == target) {
                    //numIndices[0] = i;
                    //numIndices[1] = j;
                    return new int[]{i, j};
                }
            }
        }

        //if(numIndices[0] == -1 || numIndices[1] == -1) return null;

        return null;
    }
}
