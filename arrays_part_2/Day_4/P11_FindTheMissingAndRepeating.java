package arrays_part_2.Day_4;

import java.util.ArrayList;

public class P11_FindTheMissingAndRepeating {

    // brute force
    // TC O(N + N)
    // SC O(N)
    ArrayList<Integer> findTwoElement_BF(int arr[]) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        int[] freq = new int[arr.length+1];
        
        for(int i=0; i<arr.length; i++){
            freq[arr[i]]++;
        }
        
        int missing = -1;
        int repeating = -1;
        for(int i=1; i<=arr.length; i++){
            if(freq[i] == 2) repeating = i;
            if(freq[i] == 0) missing = i;
        }
        al.add(repeating);
        al.add(missing);
        return al;
    }

    // optimal solution formula based
    // TC O(N)
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        long n = arr.length;
        
        long sn = (n * (n + 1)) / 2;
        long s2n = (n * (n + 1) * (2 * n + 1)) / 6;
        long s = 0;
        long s2 = 0;
        for(int i=0 ;i<arr.length; i++){
            s += (long)arr[i];
            s2 += (long)arr[i] * (long)arr[i];
        }
        
        long val1 = s - sn;
        long val2 = s2 - s2n;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        
        al.add((int)x);
        al.add((int)y);
        return al;
    }
}
