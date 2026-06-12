package arrays_part_3.Day_6;

public class P17_UniquePath {
    // Brute Force
    // TC O(2 ^ m + n)
    public int func(int i, int j) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        int up = func(i-1, j);
        int left = func(i, j-1);
        return up + left;
    }
    public int uniquePaths_BF(int m, int n) {
        int i = m-1;
        int j = n-1;
        return func(i, j); 
    }

    // optimal solution..
    //TC O(n)
    public int uniquePaths(int m, int n) {
        int totalMoves = m + n - 2;
        int k = Math.min(m - 1, n - 1); // Choosing the smaller one optimizes the loop
        
        double res = 1;
        
        // Calculate combination dynamically to prevent integer overflow
        for (int i = 1; i <= k; i++) {
            res = res * (totalMoves - k + i) / i;
        }
        
        return (int) Math.round(res);
    }
}
