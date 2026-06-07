package arrays_part_1;

public class KadanesAlgo_sub_array_sum {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;

            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
