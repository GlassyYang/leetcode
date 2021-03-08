import java.util.*;

public class Solution132 {
    // 搜索超时了。
    // 动态规划做一做
    public int minCutSearch(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> sta = new Stack<>();
        return recusive(s, 0, sta);
    }

    public int recusive(String s, int index, Stack<Integer> sta){
        int begin, end;
        boolean flag = true;
        int min = Integer.MAX_VALUE;
        int ans;
        for(int i = index; i < s.length(); i++){
            // 验证s[index:i]是不是一个回文字符串
            begin = index;
            end = i;
            flag = true;
            for(; begin <= end; begin++, end--)
                if(s.charAt(begin) != s.charAt(end)){
                    flag = false;
                    break;
                }
            if(flag){
                begin = index;
                end = i;
                if (end + 1 >= s.length()) {
                    ans = sta.size();
                    min = ans < min ? ans : min;
                } else {
                    sta.push(end + 1);
                    ans = recusive(s, end + 1, sta);
                    if (ans < min) min = ans;
                    sta.pop();
                }
            }
        }
        return min;
    }

    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        boolean[][] huiwen = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            huiwen[i][i] = true;
            if (i > 0) huiwen[i][i - 1] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                huiwen[i][j] = huiwen[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int l = i + j;
//                System.out.printf("%d, %d\n", j, l);
                if (huiwen[j][l]) {
                    dp[j][l] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = j; k < l; k++) {
//                        System.out.printf("index left: %d, %d\n", j, k);
//                        System.out.printf("index right: %d, %d\n", k, l);
//                        System.out.printf("dp: %d, %d\n", dp[j][k], dp[k][l]);
                        if (min > dp[j][k] + dp[k + 1][l])
                            min = dp[j][k] + dp[k + 1][l];
                        System.out.println(min);
                    }
                    dp[j][l] = min == Integer.MAX_VALUE ? 0 : min;
                }
            }
        }
        return dp[0][n - 1] - 1;
    }

    public static void main(String[] args) {
        Solution132 solu = new Solution132();
        System.out.println(solu.minCut("abc"));
    }

}
