import java.util.*;

public class Solution1582 {
    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int numSpecial(int[][] mat) {
        Stack<Pair> sta = new Stack<>();
        int ans = 0;
        int count = 0;
        for (int i = 0;i < mat.length; i++) {
            count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    if (count == 0) {
                        count++;
                        sta.push(new Pair(i, j));
                    } else {
                        sta.pop();
                        break;
                    }
                }
            }
        }
        while (!sta.isEmpty()) {
            Pair temp = sta.pop();
            count = 0;
            for(int i = 0; i < mat.length; i++) {
                if(mat[i][temp.j] == 1) {
                    if(count == 0) count++;
                    else {
                        count = 0;
                        break;
                    }
                }
            }
            if (count == 1) ans++;
        }
        return ans;
    }

}
