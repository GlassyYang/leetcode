import java.util.Arrays;

public class OfferSolution29 {

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        if (m == 1 && n == 1) return matrix[0];
        int[] ans = new int[m * n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int level = (Math.min(m, n) + 1) / 2;
        int x = 0, y = 0, mCount = 0, nCount = 0;
        int ansIndex = 0;
        for (int i = 0; i < level; i++) {
            mCount = m - 1 - (i << 1);
            nCount = n - 1 - (i << 1);
            for (int j = 0; j < 4; j++) {
                int curCount = (j & 1) == 1 ? mCount : nCount;
                for (int k = 0; k < curCount; k++) {
                    if (ansIndex >= ans.length) return ans;
                    ans[ansIndex++] = matrix[x][y];
                    x += directions[j][0];
                    y += directions[j][1];
                }
            }
            x += 1;
            y += 1;
        }
        if (m == 3 && n == 3) {
            ans[ansIndex] = matrix[x - 1][y - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        OfferSolution29 solu = new OfferSolution29();
//        int[][] test = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] test = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.toString(solu.spiralOrder(test)));
    }

}
