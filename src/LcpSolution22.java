public class LcpSolution22 {

    int[][] C;

    public LcpSolution22() {
        C = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) C[i][j] = 1;
                else C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }


    public int paintingPlan(int n, int k) {
        if (k == 0 || k == n * n) return 1;
        if (k < n) return 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(n * i + n * j - i * j == k){
                    ans += C[n][i] * C[n][j];
                }
            }
        }
        return ans;
    }

}
