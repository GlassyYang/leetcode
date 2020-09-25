import java.util.*;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if(matrix.length == 0) return ans;
        int ly = -1, ry = matrix[0].length, tx = -1, bx = matrix.length;
        for(int level = 0; level < (Math.min(matrix.length, matrix[0].length) + 1) / 2; level++){
            ly += 1;
            ry -= 1;
            tx += 1;
            bx -= 1;
            // 输出第一横行
            if(ly == ry && tx == bx) {
                ans.add(matrix[tx][ly]);
                break;
            }
            if(ly == ry){
                for(int i = tx; i <= bx; i++){
                    ans.add(matrix[i][ly]);
                }
                break;
            }
            if(tx == bx){
                for(int i = ly; i <= ry; i++){
                    ans.add(matrix[tx][i]);
                }
                break;
            }
            for(int i = ly; i < ry; i++){
                ans.add(matrix[tx][i]);
            }
            for(int i = tx; i < bx; i++){
                ans.add(matrix[i][ry]);
            }
            for(int i = ry; i > ly; i--){
                ans.add(matrix[bx][i]);
            }
            for(int i = bx; i > tx; i--){
                ans.add(matrix[i][ly]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution54 solu = new Solution54();
        int[][] q = {{1},{11}};
        System.out.println(solu.spiralOrder(q));
    }
}
