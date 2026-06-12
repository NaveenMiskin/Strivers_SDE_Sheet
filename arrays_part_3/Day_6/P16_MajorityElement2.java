package arrays_part_3.Day_6;

import java.util.ArrayList;
import java.util.List;

public class P16_MajorityElement2 {

    //TC O(n + n)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        
        int number1 = 0, number2 = 0, count1 = 0, count2 = 0;
        
        for (int num : nums) {
            if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            } else if (count1 == 0) {
                number1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                number2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            }
        }

        int threshold = nums.length / 3;
        if (count1 > threshold) result.add(number1);
        if (count2 > threshold) result.add(number2);

        return result;
    }
}
