import java.util.Arrays;

public class Solution903 {
    public int numPermsDISequence(String s) {
        final int MOD = 1_000_000_007;
        final int n = s.length();
        int dp[][] = new int[n + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i <= n; ++i) {
            char chr = s.charAt(i - 1);
            for(int j = 0; j <= i; ++j) {
                if(chr == 'I') {
                    for(int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                } else {
                    for(int k = j; k < i; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i <= n; ++i) {
            res += dp[n][i];
            res %= MOD;
        }
        return res;
    }
}
