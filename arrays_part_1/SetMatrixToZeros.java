package arrays_part_1;

public class SetMatrixToZeros {

    // Brute force (m * n) + O(m * n) = O(m * n)
    public void setZeroes_BruteForce_solu(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (col[j] || row[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Optimal Solution.............O(m * n) + O(m * n) + O(m + n) = O(m * n)
    public void setZeroes_Optimal_solution(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int col0 = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0){
                        matrix[0][j] = 0;
                    }else{
                        col0 = 0;
                    }
                }
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] != 0){
                    if(matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j=0; j<n; j++) matrix[0][j] = 0;
        }

        if(col0 == 0){
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixToZeros setMatrixToZeros = new SetMatrixToZeros();

        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

        //setMatrixToZeros.setZeroes_BruteForce_solu(matrix);
        setMatrixToZeros.setZeroes_Optimal_solution(matrix);

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
