import java.util.*;

public class Solution1024 {

    public static void main(String[] args) {
//        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int[][] clips = {{0,1},{1,2}};
        Solution1024 solu = new Solution1024();
        System.out.println(solu.videoStitching(clips, 10));
    }

    // 贪心算法解决这个问题
    public int videoStitching(int[][] clips, int T) {
        if (clips == null || clips.length == 0) return -1;
        Arrays.sort(clips, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        if (clips[0][0] != 0) return -1;
        int end = 0;
        int next = 0;
        int count = 1;
        for (int[] e : clips) {
            if (e[0] <= end) {
                if (e[1] > next) next = e[1];
            } else {
                end = next;
                if(next >= T) break;
                count++;
                if (e[0] > next) return -1;
                next = e[1];
            }
        }
        return next >= T ? count : -1;
    }
}
