package arrays_part_3.Day_5;

public class P14_Pow {
    // TC = O(logN)
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(x == 0) return 0.0;

        long N = n;
        if(N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1;
        while(N > 0) {
            if(N % 2 == 1) {
                ans = ans * x;
            }
            x = x * x;
            N = N / 2;
        }
        return ans;
    }
}
