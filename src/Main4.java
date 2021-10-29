import java.util.Arrays;

public class Main4 {

    public static int count(int m, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(count(10, 10));
    }

}
