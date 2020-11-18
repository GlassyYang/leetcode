import java.util.*;

public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int begin = newInterval[0], end = newInterval[1];
        int i = 0;
        for (; i < intervals.length; i++) {
            if(intervals[i][0] <= begin){
                if(intervals[i][1] >= begin){
                    begin = intervals[i][0];
                    if(intervals[i][1] >= end){
                        end = intervals[i][1];
                    }
                }else{
                    ans.add(intervals[i]);
                }
            }else if(intervals[i][0] >= begin && intervals[i][0] <= end){
                if(intervals[i][1] >= end){
                    end = Math.max(end, intervals[i][1]);
                }
            }else if(intervals[i][0] > end) break;
        }
        ans.add(new int[]{begin, end});
        while( i < intervals.length){
            ans.add(intervals[i]);
            i++;
        }
        int[][] ansa = new int[ans.size()][];
        for (i = 0; i < ansa.length; i++) {
            ansa[i] = ans.get(i);
        }
        return ansa;
    }

    public static void main(String[] args) {
        Solution57 solu = new Solution57();
//        int[][] intervals = {{1,3}, {6,9}};
//        int[][] intervals = {{1,2},{4,5},{6,7},{8,10}, {12, 13}};
//        int[][] intervals = {{1,9}};
        int[][] intervals = {};
        int[] insert = {4,8};
        int[][] ans = solu.insert(intervals, insert);
        System.out.println(Arrays.toString(ans));
    }

}
