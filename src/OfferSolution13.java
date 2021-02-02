import java.util.*;

public class OfferSolution13 {

    // 广度优先搜索
    class Pair {
        int i, j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    // 初步的计算方法
    public int movingCount(int m, int n, int k) {
        if(m == 0 || n == 0) return 0;
        boolean[][] board = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Pair> que = new LinkedList<>();
        int count = 1;
        board[0][0] = true;
        que.offer(new Pair(0, 0));
        while (!que.isEmpty()) {
            Pair temp = que.poll();
            for(int[] direction : directions) {
                int tempI = temp.i + direction[0], tempJ = temp.j + direction[1];
                if (tempI >= 0 && tempI < m && tempJ >= 0 && tempJ < n) {
                    if (!board[tempI][tempJ] && count(tempI, tempJ) <= k) {
                        count++;
                        board[tempI][tempJ] = true;
                        que.offer(new Pair(tempI, tempJ));
                    }
                }
            }
        }
        return count;
    }
    public int movingCount2(int m, int n, int k) {
        if(m == 0 || n == 0) return 0;
        boolean[][] board = new boolean[m][n];
        int count = 1;
        board[0][0] = true;
        for (int i = 0; i < n - 1; i++) {
            if (count(0, i + 1) <= k) {
                board[0][i + 1] = true;
                count++;
            }
            else break;
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] && count(i + 1, j) <= k){
                    board[i + 1][j] = true;
                    count++;
                }
                else break;
            }
        }
        return count;
    }
    public int count(int i, int j) {
        int count = 0;
        for (;i > 0; i /= 10) count += i % 10;
        for (; j > 0; j /= 10) count += j % 10;
        return count;
    }




    public static void main(String[] args) {
        OfferSolution13 solu = new OfferSolution13();
        System.out.println(solu.movingCount2(1, 2, 1));
    }

}
