public class Solution363 {
    // 利用二维前缀和加暴力的方法做一做
    public int maxSumSubmatrix(int[][] matrix, int k) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + matrix[i][j];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 0; l < i; l++) {
                    for (int o = 0; o < j; o++) {
                        int sum = prefix[i][j] - prefix[l][j] - prefix[i][o] + prefix[l][o];
                        if (sum <= k && max < sum) max = sum;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,1},{0,-2,3}};
        Solution363 solution363 = new Solution363();
        System.out.println(solution363.maxSumSubmatrix(matrix, 2));
    }

}
