public class Solution647 {

    public int countSubstrings(String s) {
        int n = s.length();
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
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (huiwen[i][j]) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution647 solu = new Solution647();
        System.out.println(solu.countSubstrings("acb"));
    }

}
