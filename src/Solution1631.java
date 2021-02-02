import java.util.*;

public class Solution1631 {

    class Pair{
        int i;
        int j;
        int index;
        int max;
        public Pair(int i, int j, int index, int max) {
            this.i = i;
            this.j = j;
            this.index = index;
            this.max = max;
        }
    }

    // 深度优先搜索,A*算法求解:超时
    public int minimumEffortPathDF(int[][] heights) {
        boolean[][] recorder = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < recorder.length; i++) {
            Arrays.fill(recorder[i], false);
        };
        int ans = Integer.MAX_VALUE;
        Pair temp;
        int abs;
        Stack<Pair> sta = new Stack<>();
        sta.push(new Pair(0, 0, 0, 0));
        recorder[0][0] = true;
        while (!sta.isEmpty()) {
            temp = sta.peek();
//            System.out.printf("%d, %d, %d\n", temp.i, temp.j, temp.index);
            if (temp.i == heights.length - 1 && temp.j == heights[temp.i].length - 1) {
                 ans = Math.min(ans, temp.max);
                 // max 不一定是0
                 sta.pop();
                 recorder[temp.i][temp.j] = false;
                 continue;
            }
            switch (temp.index) {
                case 0:
                    temp.index++;
                    if (temp.i > 0 && !recorder[temp.i - 1][temp.j]) {
                        abs = Math.abs(heights[temp.i][temp.j] - heights[temp.i - 1][temp.j]);
                        if (abs >= ans) break;
                        sta.push(new Pair(temp.i - 1, temp.j, 0, Math.max(abs, temp.max)));
                        recorder[temp.i - 1][temp.j] = true;
                        break;
                    }
                case 1:
                    temp.index++;
                    if (temp.j  < recorder[temp.i].length - 1 && !recorder[temp.i][temp.j + 1]) {
                        abs = Math.abs(heights[temp.i][temp.j + 1] - heights[temp.i][temp.j]);
                        if (abs >= ans) break;
                        sta.push(new Pair(temp.i, temp.j + 1, 0, Math.max(abs, temp.max)));
                        recorder[temp.i][temp.j + 1] = true;
                        break;
                    }
                case 2:
                    temp.index++;
                    if (temp.i < recorder.length - 1 && !recorder[temp.i + 1][temp.j]) {
                        abs = Math.abs(heights[temp.i][temp.j] - heights[temp.i + 1][temp.j]);
                        if (abs >= ans) break;
                        sta.push(new Pair(temp.i + 1, temp.j, 0, Math.max(abs, temp.max)));
                        recorder[temp.i + 1][temp.j] = true;
                        break;
                    }
                case 3:
                    temp.index++;
                    if (temp.j > 0 && !recorder[temp.i][temp.j - 1]) {
                        abs = Math.abs(heights[temp.i][temp.j] - heights[temp.i][temp.j - 1]);
                        if (abs >= ans) break;
                        sta.push(new Pair(temp.i, temp.j - 1, 0, Math.max(abs, temp.max)));
                        recorder[temp.i][temp.j - 1] = true;
                        break;
                    }
                default:
                    recorder[temp.i][temp.j] = false;
                    sta.pop();
            }
        }
        return ans;
    }

    // 第二种方法：并查集
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 999999, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{0, 0});
            boolean[] seen = new boolean[m * n];
            seen[0] = true;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx * n + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                        queue.offer(new int[]{nx, ny});
                        seen[nx * n + ny] = true;
                    }
                }
            }
            if (seen[m * n - 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        int[][] heights = {{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}};
        Solution1631 solu = new Solution1631();
        System.out.println(solu.minimumEffortPath(heights));
    }

}
