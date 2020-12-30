import java.util.LinkedList;
import java.util.Queue;

public class Solution10 {
    // 得用栈。不过在这之前用动态规划的方法做一下

    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i < dp.length; i++){
            dp[i][0] = false;
        }
        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
            else dp[0][i] = false;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                int si = i - 1, sj = j - 1;
                if(s.charAt(si) == p.charAt(sj) || p.charAt(sj) == '.') dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(sj) == '*') {
                    if (s.charAt(si) != p.charAt(sj - 1) && p.charAt(sj - 1) != '.') dp[i][j] = dp[i][j - 2];
                    else {
                        dp[i][j] = false;
                        dp[i][j] |= dp[i][j - 2];
                        dp[i][j] |= dp[i - 1][j];
                        dp[i][j] |= dp[i - 1][j - 2];
                    }
                }
                else dp[i][j] = false;
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String argv[]) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        Solution10 solu = new Solution10();
        System.out.println(solu.isMatch("aab", "c*a*b"));
    }
}
