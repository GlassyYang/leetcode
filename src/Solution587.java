import java.util.*;

public class Solution587 {
    // 求凸包
    public int[][] outerTrees(int[][] points) {
        // 先对点进行排序
        Arrays.sort(points, (a, b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        // 先排序
        // 排序
        return null;
    }

}
