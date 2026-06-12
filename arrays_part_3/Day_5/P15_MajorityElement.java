package arrays_part_3.Day_5;

import java.util.HashMap;
import java.util.Map;

public class P15_MajorityElement {

    //TC O(n + n)
    //SC O(n)

    public int majorityElement_BF(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int ele : nums){
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        }
        int max = 0;
        int num = 0;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            Integer key = entry.getKey();
            if(entry.getValue() > max){
                max = entry.getValue();
                num = key;
            }
        }
        return num;
    }

    // TC O(n + n)
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(count == 0) {
                count = 1;
                element = nums[i];
            }
            else if(nums[i] == element) {
                count = count + 1;
            }
            else {
                count = count - 1;
            }
        }

        int actualcount = 0;
        for(int num : nums) {
            if(num == element) {
                actualcount++;
            }
        }

        if(actualcount > nums.length / 2) return element;
        return -1;
    }
}
