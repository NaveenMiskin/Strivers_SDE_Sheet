package arrays_part_4.Day_8;

import java.util.HashMap;

public class P23_CountSubarraysWithGivenXOR {
    // Brute Force.
    // TC O(n ^ 2)
     public long subarrayXor_BF(int arr[], int k) {
        // code here
        long count = 0;
        for(int i=0; i<arr.length; i++){
            int xor = 0;
            for(int j=i; j<arr.length; j++) {
                xor ^= arr[j];
                if(xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //optimal Approach..
     // TC O(n)
     // SC O(n)
    public long subarrayXor(int arr[], int k) {
        // code here
        long count = 0;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int xor = 0;
        hm.put(0, 1);
        for(int i=0; i<arr.length; i++) {
            xor ^= arr[i];
            
            int target = xor ^ k;
            
            if(hm.containsKey(target)) {
                count += hm.get(target);
            }
            
            hm.put(xor, hm.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
