public class Solution59 {

    public int[][] generateMatrix(int n) {
        if(n == 0) return null;
        int count = 0;
        int[][] ans = new int[n][n];
        int ly = -1, ry = n, tx = -1, bx = n;
        for(int level = 0; level < (n + 1) / 2; level++){
            ly += 1;
            ry -= 1;
            tx += 1;
            bx -= 1;
            // 输出第一横行
            if(ly == ry && tx == bx) {
                ans[tx][ly] = ++count;
                break;
            }
            if(ly == ry){
                for(int i = tx; i <= bx; i++){
                    ans[i][ly] = ++count;
                }
                break;
            }
            if(tx == bx){
                for(int i = ly; i <= ry; i++){
                    ans[tx][i] = ++count;
                }
                break;
            }
            for(int i = ly; i < ry; i++){
                ans[tx][i] = ++count;
            }
            for(int i = tx; i < bx; i++){
                ans[i][ry] = ++count;
            }
            for(int i = ry; i > ly; i--){
                ans[bx][i] = ++count;
            }
            for(int i = bx; i > tx; i--){
                ans[i][ly] = ++count;
            }
        }
        return ans;
    }

}
