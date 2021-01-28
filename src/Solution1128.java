import java.util.*;

public class Solution1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] buf = new int[10][10];
        for (int i = 0; i < dominoes.length; i++) {
            int[] dominoe = dominoes[i];
            if (dominoe[0] < dominoe[1]) buf[dominoe[0]][dominoe[1]]++;
            else buf[dominoe[1]][dominoe[0]]++;
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                if (buf[i][j] != 0) count += (buf[i][j] * buf[i][j] - 1) / 2;
            }
        }
        return count;
    }

}
