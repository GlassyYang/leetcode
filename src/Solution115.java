public class Solution115 {

    public int numDistinct(String s, String t) {
        // 定义s[:i], t[:j]
        int m = s.length(), n = t.length();
        int[][] buf = new int[m + 1][n + 1];
        for (int i = 0; i <=n; i++) {
            buf[0][i] = 0;
        }
        for (int i = 0; i <= m; i++) {
            buf[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    buf[i][j] = buf[i - 1][j - 1] + buf[i - 1][j];
                } else {
                    buf[i][j] = buf[i - 1][j];
                }
            }
        }
        return buf[m][n];
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        Solution115 solu = new Solution115();
        System.out.println(solu.numDistinct("11", "1"));
    }

}
