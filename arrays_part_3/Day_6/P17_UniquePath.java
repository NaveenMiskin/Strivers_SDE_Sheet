package arrays_part_3.Day_6;

public class P17_UniquePath {
    // Brute Force
    // TC O(2 ^ m + n)
    private int uniquePaths_Helper(int i, int j, int m, int n) {
    if (i == m - 1 && j == n - 1) return 1;
    if (i >= m || j >= n) return 0;
    return uniquePaths_Helper(i + 1, j, m, n) + uniquePaths_Helper(i, j + 1, m, n);
}
    public int uniquePaths_BF(int m, int n) {

        return uniquePaths_Helper(0, 0, m, n);
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

    public int uniquePaths_another_approach(int m, int n) {
        int N = m + n - 2;
        int r = m - 1;
        double res = 1;

        for(int i=1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int)res;
    }
}
