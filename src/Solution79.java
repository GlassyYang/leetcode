import java.util.Arrays;

public class Solution79 {

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        boolean[][] flags = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            Arrays.fill(flags[i], false);
        }
        // 搜索
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flags[i][j] = true;
                    if(word.length() == 1) return true;
                    if (beside(board, i, j, 1, word, flags)) {
                        return true;
                    }
                    flags[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean beside(char[][] board, int i, int j, int si, String word, boolean[][] flags) {
        boolean ans;
        if (i + 1 < board.length && board[i + 1][j] == word.charAt(si) && !flags[i + 1][j]) {
            if(si + 1 >= word.length()) return true;
            flags[i + 1][j] = true;
            ans =  beside(board, i + 1, j, si + 1, word, flags);
            flags[i + 1][j] = false;
            if(ans) return ans;
        }
        if (i >= 1 && board[i - 1][j] == word.charAt(si) && !flags[i - 1][j]) {
            if(si + 1 >= word.length()) return true;
            flags[i - 1][j] = true;
            ans = beside(board, i - 1, j, si + 1, word, flags);
            flags[i - 1][j] = false;
            if(ans) return ans;
        }
        if (j + 1 < board[i].length && board[i][j + 1] == word.charAt(si) && !flags[i][j + 1]) {
            if(si + 1 >= word.length()) return true;
            flags[i][j + 1] = true;
            ans = beside(board, i, j + 1, si + 1, word, flags);
            flags[i][j + 1] = false;
            if(ans) return ans;
        }
        if (j >= 1 && board[i][j - 1] == word.charAt(si) && !flags[i][j - 1]) {
            if(si + 1 >= word.length()) return true;
            flags[i][j - 1] = true;
            ans = beside(board, i, j - 1, si + 1, word, flags);
            flags[i][j - 1] = false;
            return ans;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        Solution79 solu = new Solution79();
        System.out.println(solu.exist(board, "AAB"));
    }

}
