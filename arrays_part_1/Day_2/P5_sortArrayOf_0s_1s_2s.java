package arrays_part_1.Day_2;

public class P5_sortArrayOf_0s_1s_2s {

    //   Dutch National Flag Algorithm.......................

     public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;;
        int mid = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[mid] == 0) {
                swap(nums, l, mid);
                l++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, r);
                r--;
            }
        }
    }
}