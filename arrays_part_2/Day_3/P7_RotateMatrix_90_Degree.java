package arrays_part_2.Day_3;

public class P7_RotateMatrix_90_Degree {

    // TC -> O(N^2) + O(N^2)
    // SC -> O(1)
    public void transpose(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;

        for(int i=0; i<m; i++){
            for(int j=i+1; j<n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public void reverse(int[][] arr){
        int m = arr.length;

        for(int i=0; i<m; i++){
            int lp = 0;
            int rp = m - 1;

            while(lp < rp){
                int temp = arr[i][lp];
                arr[i][lp] = arr[i][rp];
                arr[i][rp] = temp;
                lp++;
                rp--;
            }
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
}
