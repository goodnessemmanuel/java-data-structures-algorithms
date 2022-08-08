package com.ocheejeh.leetcode;

public class MinimumSwapNumbers {
    public int minSwaps(String s) {
        int ones = 0;
        int zeros = 0;

        //count no. of zeros and ones
        for(char c: s.toCharArray()){
            if(c=='0')
                zeros++;
            else
                ones++;
        }

        //base case we cannot make it alternative if this is the case
        if(Math.abs(ones-zeros)>1)
            return -1;

        //if ones are more, the string should start with 1
        if(ones>zeros)
            return findMinSwaps(s, '1');

        //string should start with 0
        if(zeros>ones)
            return findMinSwaps(s, '0');

        //if both are equal, lets check both possibilities
        return Math.min(findMinSwaps(s, '1'),findMinSwaps(s, '0'));
    }


    //we are counting the no. of changes we are doing, but we are basically swapping two indexes,
    //so return /2
    public int findMinSwaps(String s, char ch){
        int minSwaps = 0;

        for(char c: s.toCharArray()){
            if(c!=ch)
            {
                minSwaps++;
            }
            ch = (ch == '1')? '0':'1';
        }

        return minSwaps/2;
    }
}
