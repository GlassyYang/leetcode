import java.util.*;

public class Solution37 {

    public void solveSudoku(char[][] board) {
        char[][] board_cp = new char[9][9];
        BitSet[] rows = new BitSet[9], columns = new BitSet[9], sudoku = new BitSet[9];
        for(int i = 0; i < 9; i++){
            rows[i] = new BitSet(10);
            columns[i] = new BitSet(10);
            sudoku[i] = new BitSet(10);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board_cp[i][j] = board[i][j];
                if(board[i][j] == '.') board[i][j] = '0';
                else{
                    rows[i].set(board[i][j] - '0');
                    columns[j].set(board[i][j] - '0');
                    sudoku[(i / 3) * 3 + j / 3].set(board[i][j] - '0');
                }
            }
        }
        int i = 0, j = 0;
        while(i < 9){
//            if(i == 0 && j == 2){
//                System.out.println("test");
//            }
            if(board_cp[i][j] == '.'){
                boolean flag = false;
                for(int k = board[i][j] + 1; k <='9'; k++){
                    if(!rows[i].get(k - '0') && !columns[j].get(k - '0') && !sudoku[(i / 3) * 3 + j / 3].get(k - '0')){
                        board[i][j] = (char)k;
                        rows[i].set(k - '0');
                        columns[j].set(k - '0');
                        sudoku[(i / 3) * 3 + j / 3].set(k - '0');
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    board[i][j] = '0';
                    do {
                        j--;
                        if (j < 0) {
                            j = 8;
                            i--;
                        }
                        if(i < 0){
                            System.out.println("stop here");
                        }
                    }while(board_cp[i][j] != '.');
                    rows[i].flip(board[i][j] - '0');
                    columns[j].flip(board[i][j] - '0');
                    sudoku[(i / 3) * 3 + j / 3].flip(board[i][j] - '0');
                    continue;
                }
            }
            j++;
            if(j >= 9) {
                j = 0;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        Solution37 solu = new Solution37();
        solu.solveSudoku(board);
        for(int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

}
