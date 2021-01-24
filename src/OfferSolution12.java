import java.util.*;

public class OfferSolution12 {

    class Pair {
        int i, j;
        Pair(int i , int j) {
            this.i = i;
            this.j = j;
        }
    }

    public boolean exist(char[][] board, String word) {
        int index = 0;
        Stack<Pair> sta = new Stack<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(index)) {
                    int curI = i, curJ = j;
                    sta.push(new Pair(curI, curJ));
                    board[curI][curJ] = '\00';
                    index++;
                    while (index < word.length()) {
                        if (curI > 0 && board[curI - 1][curJ] == word.charAt(index)) {
                            curI -= 1;
                            board[curI][curJ] = '\00';
                            sta.push(new Pair(curI, curJ));
                        } else if (curI < board.length - 1 && board[curI + 1][curJ] == word.charAt(index)) {
                            curI += 1;
                            board[curI][curJ] = '\00';
                            sta.push(new Pair(curI, curJ));
                        } else if (curJ > 0 && board[curI][curJ - 1] == word.charAt(index)) {
                            curJ -= 1;
                            board[curI][curJ] = '\00';
                            sta.push(new Pair(curI, curJ));
                        }  else if (curJ < board[curI].length - 1 && board[curI][curJ + 1] == word.charAt(index)) {
                            curJ += 1;
                            board[curI][curJ] = '\00';
                            sta.push(new Pair(curI, curJ));
                        } else {
                            break;
                        }
                        index++;
                    }
                    if (index == word.length()) return true;
                    else {
                        while (!sta.isEmpty()) {
                            Pair temp = sta.pop();
                            board[temp.i][temp.j] = word.charAt(--index);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'a'}, {'a'}};
        String word = "ABCCED";
        OfferSolution12 solu = new OfferSolution12();
        System.out.println(solu.exist(board, word));
    }
}
