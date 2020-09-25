import java.util.*;

public class Solution56 {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0)return intervals;
        sort(intervals);
        Stack<int[]> ansl = new Stack<>();
        ansl.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] anstemp = new int[2];
            if(intervals[i][0] <= ansl.peek()[1]){
                int[] temp = ansl.pop();
                anstemp[0] = temp[0];
                anstemp[1] = Math.max(temp[1], intervals[i][1]);
            }else{
                anstemp[0] = intervals[i][0];
                anstemp[1] = intervals[i][1];
            }
            ansl.push(anstemp);
        }
        int[][] ans = new int[ansl.size()][];
        int count = 0;
        for(int[] e : ansl){
            ans[count] = e;
            count++;
        }
        return ans;
    }

    public void sort(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] nums0, int[] nums1) {
                return nums0[0] - nums1[0];
            }
        });
    }

    public static void main(String[] args) {
        Solution56 solu = new Solution56();
        solu.merge(new int[][]{{1,3}, {2,6}, {15,18}, {8,10}});
    }

}
