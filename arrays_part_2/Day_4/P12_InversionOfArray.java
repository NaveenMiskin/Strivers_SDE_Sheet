package arrays_part_2.Day_4;

import java.util.ArrayList;
import java.util.List;

public class P12_InversionOfArray {

    // TC O(N logN)

    public static int merge(int[] arr, int low, int mid, int high) {
        // Create temp array
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        
        int cnt = 0;

        // Merge both sorted parts
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp.add(arr[left++]);
                
            else {
                temp.add(arr[right]);
                cnt += mid - left + 1;
                right++;
            }
        }

        // Add remaining left elements
        while (left <= mid)
            temp.add(arr[left++]);

        // Add remaining right elements
        while (right <= high)
            temp.add(arr[right++]);

        // Copy back to original array
        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low);
            
        return cnt;
    }

    // Recursive merge sort
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;

        // Find mid index
        int mid = (low + high) / 2;

        // Sort left half
        cnt += mergeSort(arr, low, mid);

        // Sort right half
        cnt += mergeSort(arr, mid + 1, high);

        // Merge both halves
        cnt += merge(arr, low, mid, high);
        return cnt;
    }
    
    static int inversionCount(int arr[]) {
        // Code Here
        return mergeSort(arr, 0, arr.length-1);
        
    }
}