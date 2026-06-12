package arrays_part_4.Day_7;

import java.util.Arrays;
import java.util.HashSet;

public class P21_LongestConsecutiveinArray {

    // Brute Force
    // TC O(nlogn + n)
    // SC O(1)

    public int longestConsecutive_BF(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int longestlength = 1;
        int lastsmaller = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]-1 == lastsmaller){
                cnt++;
                lastsmaller = nums[i];
            }
            else if(nums[i] != lastsmaller){
                cnt = 1;
                lastsmaller = nums[i];
            }
            longestlength = Math.max(longestlength, cnt);
        }
        return longestlength;
    }

    // Optimal solution
    // TC O(n + n)
    // SC O(n)
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int longest = 1;
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            hs.add(nums[i]);
        }

        for(int ele : hs){
            if(!hs.contains(ele-1)){
                int cnt = 1;
                int x = ele;
                while(hs.contains(x + 1)){
                    x += 1;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}