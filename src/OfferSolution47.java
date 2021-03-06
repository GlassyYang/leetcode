public class OfferSolution47 {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j + 1] = Math.max(dp[j], dp[j + 1]) + grid[i][j];
            }
        }
        return dp[n];
    }

}
