import java.util.*;

public class Solution435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b)->{ return a[0] - b[0];});
        int removed = 0, end = intervals[0][1], sL = intervals[0][1] - intervals[0][0];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < end) {
                if(intervals[i][1] < end) end = intervals[i][1];
                removed++;
            }else {
                end = intervals[i][1];
            }
        }
        return removed;
    }

    public static void main(String[] args) {
        Solution435 solu = new Solution435();
        int[][] intervals = { {1,2}, {1,2}, {1,2}, {1,2} };
        System.out.println(solu.eraseOverlapIntervals(intervals));
    }

}
