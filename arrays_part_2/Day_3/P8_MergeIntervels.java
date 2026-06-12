package arrays_part_2.Day_3;

import java.util.Arrays;

public class P8_MergeIntervels {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int n = intervals.length;
        int[][] res = new int[n][2];

        res[0] = intervals[0];
        int idx = 0;
        for(int i=1; i<n; i++){
            int st = intervals[i][0];
            int ed = intervals[i][1];

            if(st <= res[idx][1]){
                res[idx][1] = Math.max(res[idx][1], ed);
            }
            else {
                idx++;
                res[idx] = intervals[i];
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}