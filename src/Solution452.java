import java.util.*;

public class Solution452 {

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        Arrays.sort(points, (int[] a, int[] b)->{return a[0] - b[0];});
        Arrays.sort(points, (int[] a, int[] b)->{return a[1] - b[1];});
        int start = points[0][0], end = points[0][1];
        int count = 0;
        for(int i = 1; i < points.length; i++){
             if((points[i][0] <= end && points[i][1] >= end) || (points[i][0] <= start && points[i][1] >= start)){
                 start = Math.max(points[i][0], start);
                 end = Math.min(points[i][1], end);
             }else{
                 count++;
                 start = points[i][0];
                 end = points[i][1];
             }
        }
        return count + 1;
    }

    public static void main(String[] args) {
//        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = {{1,2}, {2,3}, {3,4}, {4,5}};
        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        Solution452 solu = new Solution452();
        System.out.println(solu.findMinArrowShots(points));

    }

}
