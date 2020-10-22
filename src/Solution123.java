import java.util.*;

public class Solution123 {
    // 看了答案，直接放弃
    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length < 2) return 0;
//        int[][] p1 = new int[prices.length - 1][prices.length - 1];
//        int[][] p2 = new int[prices.length - 1][prices.length - 1];
//        for(int i = 0; i < prices.length - 1; i++) p1[i][i] = prices[i + 1] - prices[i];
//        for(int i = 1; i < prices.length - 1; i++){
//            for(int j = 0; j < prices.length - i; j++){
//                int max = p[j][j+1];
//                for(int k = j + 1; k < i; k++){
//                    if(max < p[j][k]) max = p[j][k];
//                    if(max < p[k][i]) max = p[k][i];
//                    if(max < p[j][k] + p[k][i]) max = p[j][k] + p[k][i];
//                }
//                p[j][i] = max;
//            }
//        }
//        return Math.max(p[0][prices.length - 1], 0);
        return 0;
    }

    public static void main(String[] args) {
        int[] test = {3,3,5,0,0,3,1,4};
        Solution123 solu = new Solution123();
        System.out.println(solu.maxProfit(test));
    }

}
