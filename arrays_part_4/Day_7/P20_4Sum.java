package arrays_part_4.Day_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P20_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> sum4 = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1;
                int r = nums.length - 1;

                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                while (l < r) {
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        sum4.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;

                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                        while (l < r && nums[r] == nums[r + 1])
                            r--;

                    } else if (sum < target) {
                        l++;
                    } else
                        r--;
                }
            }
        }
        return sum4;
    }
}
