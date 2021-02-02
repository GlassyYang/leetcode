import java.util.*;

public class Solution778 {

    class Pair {
        int i;
        int j;
        int weight;

        public Pair(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }
    }

    // 用A*算法的思想做这个题
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        que.offer(new Pair(0, 0, grid[0][0]));
        boolean[][] visited = new boolean[n][n];
        int ret = 0;
        while (!que.isEmpty()) {
            Pair temp = que.poll();
            if (visited[temp.i][temp.j]) {
                continue;
            }
            visited[temp.i][temp.j] = true;
            ret = Math.max(ret, grid[temp.i][temp.j]);
            if (temp.i == n - 1 && temp.j == n - 1) break;
            for (int[] direction : dirs) {
                int ni = temp.i + direction[0], nj = temp.j + direction[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                    if (!visited[ni][nj]) {
                        que.offer(new Pair(ni, nj, grid[ni][nj]));
                    }
                }
            }
        }
        return ret;
    }
}
