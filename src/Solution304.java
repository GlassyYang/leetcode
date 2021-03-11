public class Solution304 {

}
// 二维前缀和
class NumMatrix {

    int[][] prefixSum;
    int m,n;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = m > 0 ? matrix[0].length : 0;
        prefixSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0) prefixSum[i][j] = matrix[i][j];
                    else prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    prefixSum[i][j] = prefixSum[i - 1][j] + matrix[i][j];
                } else {
                    prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row2 >= m || col2 >= n) return -1;
        if (row1 == 0) {
            if (col1 == 0) return prefixSum[row2][col2];
            return prefixSum[row2][col2] - prefixSum[row2][col1 - 1];
        } else if (col1 == 0) {
            return prefixSum[row2][col2] - prefixSum[row1 - 1][col2];
        }
        row1--;
        col1--;
        return prefixSum[row2][col2] - prefixSum[row1][col2] - prefixSum[row2][col1] + prefixSum[row1][col1];
    }
}
