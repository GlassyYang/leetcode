import java.util.*;

public class Main3 {

    static int minCost(int[][] arr) {
        final int m = arr.length, n = arr[0].length;
        int[] dp = new int[ n + 1];
        dp[n] = 1;
        for(int i = m - 1; i >= 0; --i) {
            for(int j = n - 1; j >= 0; --j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) - arr[i][j];
                dp[j] = Math.max(1, dp[j]);
            }
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] arr = {{-2, -3 , 3},{-5, -10, 1},{0 , 30, -5}};
        System.out.println(minCost(arr));
    }

}
