package com.ocheejeh.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *The appeal of a string is the number of distinct characters found in the string.
 * For example, the appeal of "abbca" is 3 because it has 3 distinct characters: 'a', 'b', and 'c'.
 * Given a string s, return the total appeal of all of its substrings.
 * A substring is a contiguous sequence of characters within a string.
 * Input: s = "abbca"
 * Output: 28
 * Explanation: The following are the substrings of "abbca":
 * - Substrings of length 1: "a", "b", "b", "c", "a" have an appeal of 1, 1, 1, 1, and 1 respectively. The sum is 5.
 * - Substrings of length 2: "ab", "bb", "bc", "ca" have an appeal of 2, 1, 2, and 2 respectively. The sum is 7.
 * - Substrings of length 3: "abb", "bbc", "bca" have an appeal of 2, 2, and 3 respectively. The sum is 7.
 * - Substrings of length 4: "abbc", "bbca" have an appeal of 3 and 3 respectively. The sum is 6.
 * - Substrings of length 5: "abbca" has an appeal of 3. The sum is 3.
 * The total sum is 5 + 7 + 7 + 6 + 3 = 28.
 *
 * Input: s = "code"
 * Output: 20
 * Explanation: The following are the substrings of "code":
 * - Substrings of length 1: "c", "o", "d", "e" have an appeal of 1, 1, 1, and 1 respectively. The sum is 4.
 * - Substrings of length 2: "co", "od", "de" have an appeal of 2, 2, and 2 respectively. The sum is 6.
 * - Substrings of length 3: "cod", "ode" have an appeal of 3 and 3 respectively. The sum is 6.
 * - Substrings of length 4: "code" has an appeal of 4. The sum is 4.
 * The total sum is 4 + 6 + 6 + 4 = 20
 */
public class TotalAppealOfAString {
    public static void main(String[] args) {
        String test = "jffqgvjzoulfnzaniqpjlriqdogyplgteifddtnhyxbzsbyllsnhopualudvdohnypwqapuujyccjktycjccbuiglvruccoyiawjcdjlumthwyirlrxumhkfikmqrjalidgfgfmhhwxrrepqnsjlqreanvnjjdocjlajajboiyplbsvnpvwvehihenpgkypovxjoouwrqkyutkfyralbamjhjsidljspemqiytgiofaeyngztqmdpredrulhepqwrryugsvrqnuywsokyykrjdpgkftgfyroooemyvqbpfaepyhsbilmepjczjczzddasqrvlkdagotixfunwogdlhftcnnrozdjgrezgcipmuzkhinzzvtqfrpksicvlgbiozeyvgsapaxqljyyocwmoystvigczzpecyjoqqejqfnvggstaqyjtsjuvezqmzthcfynvtxwrzegkssnvnibaojbllexjzxzmepfgqpgvjgkrruwengonivmgwrauilfxdjsnywuaycnwowvykdelufbkhuxclepfelnpmkhaesvbmfrsmfbogrqyxpagglxmippfabeyilkrijzxgusblkjjjgnpzdmaoulprqleeturrpolxuxkuaxfnrhubbsqpmeecwofxfnbhhxvzoftnqsfgtlivcmufmwmwqltmhvuggflllnoniamidilprrqqprnsbjfnvdktcsulipffcxamjxtlsecoyraqexzstmdgeaytxgvzfmwcvztabkejssrqivkimgyphcaloejqfiqymfwwrhguuqgxdmqvrydjzzjwqocirukytgvgdshlcqmjtzfrektmviwgeejtvrddocgwdfliuxnhgulqyphuijxqdppoacpwxojsfbdksordrcvcgvzebnrskhjrcmyahhruopmedynccwhdh";
        //System.out.println(appealSum("code"));
        System.out.println("non optimized count: " + appealSum(test));
        TotalAppealOfAString obj = new TotalAppealOfAString();
        System.out.println("optimized count: " + obj.appealSumOptimized(test));
    }
    public static long appealSum(String s){
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int limit = 0; limit < s.length(); limit++) {
            int visited = 0;
            for (int i = 0; i < s.length(); i++) {
                visited++;
                if(visited + limit > s.length()) break;
                String sub = s.substring(i, visited + limit);
                Character[] charObjectArray = sub.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
                Set<Character> characterSet = new HashSet<>(Arrays.asList(charObjectArray));
                //Set<Character> characterSet = Arrays.stream(charObjectArray).collect(Collectors.toSet());
                sum += characterSet.size();

            }

        }
        System.out.println("Non optimized time spent: " + (System.currentTimeMillis() - startTime));
        return sum;
    }

    /**
     * Building the Logic 🤔
     *
     * These type questions follow a similar pattern.
     * In questions where you are asked to count something in every substring / subarray of a 'N' size array / string having N = 10^5 . Then dont even try to generate all possible substrings/subarrays as it would definitely lead to TLE (i.e. Time Limit Exceeded).
     * What we can do ::: Just See How much contribution every element can provide to the answer in just one For Loop 👉🏻 O(N)
     *
     * 📌 Explanation ✍🏻
     *
     * Consider string "bcde"
     *
     * 🎯 lets talk about character 'c' that in how many substrings this 'c' will be counted as unique string
     * ::: left no of characters on L.H.S of 'c' = left
     * ::: left no of characters on R.H.S of 'c' = right
     * Then total possible substrings containing this 'c' = (left+1) x (right+1)
     *
     * Thus contributions for c = 2 * 3 = 6
     * and those 6 substrings are ( bc, bcd, bcde, c, cd, cde )
     *
     * So we can say that every character will have contribution of (left+1)x(right+1) to the ans.
     *
     * 🎯 But there is one small catch here !
     * What if characters are same ?? then only one of those characters will have contribution in any substring containing them.
     * "acca"
     * Here first 'c' will for sure have a contribution = (left+1)x(right+1) = 2 x 3 = 6
     * but for second 'c' Left region will be reduced till the rightmost 'c' on leftside. So the value of left for second 'c' will be = 0 !!
     * Right will have no change.
     * So contribution for second 'c' = 1 x 2 = 2;
     *
     * This way we can calculate the contribution for each and every character in just one for loop.
     *
     * ✅ Time Complexity = O(N)
     * ✅ Space Complexity = O(26) = O(1)
     */

    public long appealSumOptimized(String s) {
        long startTime = System.currentTimeMillis();
        int l = s.length();
        int[] lo = new int[26];  //store the last occurrence index of every character
        Arrays.fill(lo,-1);

        long ans = 0;
        for(int i=0;i<l;i++)
        {
            int cc = s.charAt(i)-'a';
            int right = l-i-1;
            int left;

            int last = lo[cc];
            if(last==-1) left = i;
            else left = (i-last)-1;
            ans += (left+1)*(right+1);
            lo[cc] = i;
        }
        System.out.println("Optimized time spent: " + (System.currentTimeMillis() - startTime));
        return ans;
    }
}
