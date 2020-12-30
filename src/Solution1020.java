import java.util.*;

public class Solution1020 {
    // 广度优先搜索找到结果
    public int numEnclaves(int[][] A) {
        int ansCount = 0, count;
        boolean flag = false;
        Queue<Integer> quei = new LinkedList<>();
        Queue<Integer> quej = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    flag = true;
                    count = 0;
                    quei.offer(i);
                    quej.offer(j);
                    while(!quei.isEmpty()) {
                        int ai = quei.poll(), aj = quej.poll();
                        if( flag && (ai == 0 || aj == 0 || ai == A.length - 1 || aj == A[i].length - 1)) flag = false;
                        count++;
                        A[ai][aj] = 2;
                        if (ai > 0 && A[ai - 1][aj] == 1) {
                            quei.offer(ai - 1);
                            quej.offer(aj);
                        }
                        if (ai < A.length - 1 && A[ai + 1][aj] == 1) {
                            quei.offer(ai + 1);
                            quej.offer(aj);
                        }
                        if (aj > 0 && A[ai][aj - 1] == 1) {
                            quei.offer(ai);
                            quej.offer(aj - 1);
                        }
                        if (aj < A[ai].length - 1  && A[ai][aj + 1] == 1) {
                            quei.offer(ai);
                            quej.offer(aj + 1);
                        }
                    }
                    if (flag) ansCount += count;
                }
            }
        }
        return ansCount;
    }

    public static void main(String[] args) {
        int[][] test = {{0,0,0,1,1,1,0,1,1,1,1,1,0,0,0},{1,1,1,1,0,0,0,1,1,0,0,0,1,1,1},{1,1,1,0,0,1,0,1,1,1,0,0,0,1,1},{1,1,0,1,0,1,1,0,0,0,1,1,0,1,0},{1,1,1,1,0,0,0,1,1,1,0,0,0,1,1},{1,0,1,1,0,0,1,1,1,1,1,1,0,0,0},{0,1,0,0,1,1,1,1,0,0,1,1,1,0,0},{0,0,1,0,0,0,0,1,1,0,0,1,0,0,0},{1,0,1,0,0,1,0,0,0,0,0,0,1,0,1},{1,1,1,0,1,0,1,0,1,1,1,0,0,1,0}};
        Solution1020 solu = new Solution1020();
        System.out.println(solu.numEnclaves(test));
    }

}
