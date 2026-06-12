package arrays_part_4.Day_7;

import java.util.HashMap;
import java.util.Map;

public class P19_TwoSum {
    // TC O(n)
    // SC O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int next = target - nums[i];
            if(hm.containsKey(next)){
                return new int[]{hm.get(next), i};
            }
            hm.put(nums[i], i);
        }
        return new int[]{};
    }
}
