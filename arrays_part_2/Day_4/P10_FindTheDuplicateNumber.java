package arrays_part_2.Day_4;

import java.util.Arrays;

public class P10_FindTheDuplicateNumber {
    // Brute Force

    // TC O(NlogN) + O(N);

    public int findDuplicate_Brute_force(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for(int j=1; j<nums.length; j++){
            if((nums[i] ^ nums[j]) == 0) return nums[i];
            i++;
        }
        return 0;
    }

    // optimal sol
    // TC O(N)
    public int findDuplicate(int[] nums) {
        int s = nums[0];
        int f = nums[nums[0]];
        while(s != f) {
            s = nums[s];
            f = nums[nums[f]];
        }

        s = 0;
        while(s != f){
            s = nums[s];
            f = nums[f];
        }
        return s;
    }
}
