import java.util.Arrays;

public class Solution62 {
    // 最简单的动态规划
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        int[] buf = new int[n];
        Arrays.fill(buf, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++){
                buf[j] += buf[j - 1];
            }
        }
        return buf[n - 1];
    }

    public static void main(String[] args) {
        Solution62 solu = new Solution62();
        System.out.println(solu.uniquePaths(0, 0));
    }

}
