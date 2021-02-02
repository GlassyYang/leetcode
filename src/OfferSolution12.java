import java.util.*;

public class OfferSolution12 {

    class Pair {
        int i, j, dir, si;
        Pair(int i , int j, int dir, int si) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.si = si;
        }
    }

    public boolean exist(char[][] board, String word) {
        int index = 0;
        int m = board.length, n = board[0].length;
        Stack<Pair> sta = new Stack<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] recorder = new boolean[board.length][board[0].length];
        Pair temp;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(index)) {
                    // 深度优先搜索
                    sta.push(new Pair(i, j, 0, 0));
                    recorder[i][j] = true;
                    while (!sta.isEmpty()) {
                        temp = sta.peek();
                        if (temp.si >= word.length() - 1) return true;
                        if (temp.dir >= 4) {
                            recorder[temp.i][temp.j] = false;
                            sta.pop();
                        }
                        while (temp.dir < 4) {
                            int ni = temp.i + directions[temp.dir][0], nj = temp.j + directions[temp.dir][1];
                            temp.dir++;
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !recorder[ni][nj]) {
                                if (board[ni][nj] == word.charAt(temp.si + 1)) {
                                    recorder[ni][nj] = true;
                                    sta.push(new Pair(ni, nj, 0, temp.si + 1));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        OfferSolution12 solu = new OfferSolution12();
        System.out.println(solu.exist(board, word));
    }
}
