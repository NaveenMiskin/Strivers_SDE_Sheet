package arrays_part_3.Day_5;

public class P13_SearchInAMatrix {

    // TC O(n * log n)
    boolean bs(int[] arr, int target) {
        int l = 0;
        int r = arr.length-1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) return true;
            if(arr[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            if(bs(matrix[i], target)) return true;
        }
        return false;
    }
}