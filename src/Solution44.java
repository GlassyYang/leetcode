import java.util.*;

public class Solution44 {

    public boolean isMatch(String s, String p) {
        boolean[][] bp = new boolean[s.length() + 1][p.length() + 1];
        bp[0][0] = true;
        for (int i = 1; i < bp.length; i++) {
            bp[i][0] = false;
        }
        for (int i = 1; i < bp[0].length; i++) {
            if (p.charAt(i - 1) == '*') bp[0][i] = bp[0][i - 1];
            else bp[0][i] = false;
        }
        // 初始化数组，之后开始进行匹配
        for (int i = 1; i < bp.length; i++) {
            for (int j = 1; j < bp[0].length; j++) {
                int si = i - 1, pi = j - 1;
                if(s.charAt(si) == p.charAt(pi)|| p.charAt(pi) == '?') bp[i][j] = bp[i - 1][j - 1];
                else if (p.charAt(pi) == '*') {
                    bp[i][j] |= bp[i - 1][j];       // 单个的情况
                    bp[i][j] |= bp[i - 1][j - 1];   // 多个的情况
                    bp[i][j] |= bp[i][j - 1];   // 为0的情况
                }
                else
                    bp[i][j] = false;
            }
        }
        return bp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution44 solu = new Solution44();
        System.out.println(solu.isMatch("zacabz", "*a?b*"));
    }

}
