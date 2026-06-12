package arrays_part_4.Day_8;

import java.util.HashMap;

public class P22_largestSubArrrayWithKSum {


    //brute Force 
    // TC O(n ^ 2)
    // SC O(1)
    public int longestSubarray_BF(int[] arr, int k) {
        // code here

        int maxlen = 0;
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                if(sum == k) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }
        }
        return maxlen;
    }

    // optimal solution
    // TC O(n)
    // SC O(n)

    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int maxlen = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            
            if(sum == k) {
                maxlen = i+1;
            }
            
            if(hm.containsKey(sum - k)) {
                maxlen = Math.max(maxlen, i - hm.get(sum - k));
            }
            
            if(!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return maxlen;
    }
}