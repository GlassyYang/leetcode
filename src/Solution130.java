import java.util.Arrays;

public class Solution130 {

    // 深度优先搜索解决问题
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        //pass
        // 深度优先搜索解决问题。
        for(int i = 0; i < board[0].length; i++) if(board[0][i] == 'O') recusive(0, i, board);
        for(int i = 1; i < board.length; i++) if(board[i][board[0].length - 1] == 'O') recusive(i, board[0].length - 1, board);
        for(int i = board[0].length - 2; i >= 0; i--) if(board[board.length - 1][i] == 'O') recusive(board.length - 1, i, board);
        for(int i = board.length - 2; i > 0; i--) if(board[i][0] == 'O') recusive(i, 0, board);
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '\0') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    public void recusive(int i , int j , char[][] board){
        System.out.println(i);
        System.out.println(j);
        board[i][j] = '\0';
        if(j + 1 < board[i].length && board[i][j + 1] == 'O') recusive(i, j + 1, board);
        if(j > 0 && board[i][j - 1] == 'O') recusive(i, j - 1, board);
        if(i > 0 && board[i - 1][j] == 'O') recusive(i - 1, j, board);
        if(i + 1 < board.length && board[i + 1][j] == 'O') recusive(i + 1, j, board);
    }

    public static void main(String[] args) {
        char[][] board = new char[4][];
        board[0] = new char[]{'X', 'O', 'X', 'O', 'X'};
        board[1] = new char[]{'O', 'X', 'O', 'X', 'O'};
        board[2] = new char[]{'X', 'O', 'X', 'O', 'X'};
        board[3] = new char[]{'O', 'X', 'O', 'X', 'O'};
//        board[4] = new char[]{'X', 'O', 'X', 'O', 'X'};
        Solution130 solu = new Solution130();
        solu.solve(board);
        for(char[] e : board) System.out.println(Arrays.toString(e));
    }

}
