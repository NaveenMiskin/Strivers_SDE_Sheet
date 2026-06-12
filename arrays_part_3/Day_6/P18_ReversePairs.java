package arrays_part_3.Day_6;

public class P18_ReversePairs {

    // Tc O(n logn)
    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int index = 0;

        // Standard merge process
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= high) {
            temp[index++] = nums[right++];
        }

        System.arraycopy(temp, 0, nums, low, temp.length);
    }
    private int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int rightPointer = mid + 1;

        // For every element in the left half, find matching elements in the right half
        for (int i = low; i <= mid; i++) {
            while (rightPointer <= high && (long) nums[i] > 2 * (long) nums[rightPointer]) {
                rightPointer++;
            }
            // All elements from (mid + 1) to (rightPointer - 1) satisfy the condition
            count += (rightPointer - (mid + 1));
        }
        return count;
    }
    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        
        int mid = low + (high - low) / 2;
        int count = 0;

        // 1. Count pairs in the left and right sub-arrays
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        // 2. Count the cross-pairs between left and right halves
        count += countPairs(nums, low, mid, high);

        // 3. Merge the two sorted halves
        merge(nums, low, mid, high);

        return count;
    }
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }
}
