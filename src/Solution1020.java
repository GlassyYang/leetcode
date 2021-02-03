import java.util.*;

public class Solution1020 {
    // 广度优先搜索找到结果
    int row, col;
    int[][] A;

    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0) return 0;
        this.A = A;
        this.row = A.length;
        this.col = A[0].length;

        // 淹没所有和边界相接的陆地
        for (int i = 0; i < row; i++) {
            dfs(i, 0);
            dfs(i, col - 1);
        }
        for (int i = 0; i < col; i++) {
            dfs(0, i);
            dfs(row - 1, i);
        }
        // 统计剩下的飞陆
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) count++;
            }
        }
        return count;
    }

    public void dfs(int r, int c) {
        if (A[r][c] == 0) return;

        A[r][c] = 0;
        if (r > 0) {
            dfs(r - 1, c);
        }
        if (c > 0) {
            dfs(r, c - 1);
        }
        if (r < row - 1) {
            dfs(r + 1, c);
        }
        if (c < col - 1) {
            dfs(r, c + 1);
        }
    }

    public static void main(String[] args) {
        int[][] test = {{0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0}};
        Solution1020 solu = new Solution1020();
        System.out.println(solu.numEnclaves(test));
    }

}
