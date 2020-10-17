import java.util.*;

public class Solution122 {

    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[][] p = new int[prices.length - 1][prices.length - 1];
        for(int i = 0; i < prices.length - 1; i++) p[i][i] = prices[i + 1] - prices[i];
        for(int i = 2; i < prices.length; i++){
            for(int j = 0; j < prices.length - i; j++){
                int max = p[j][j+1];
                for(int k = j + 1; k < i; k++){
                    if(max < p[j][k]) max = p[j][k];
                    if(max < p[k][i]) max = p[k][i];
                    if(max < p[j][k] + p[k][i]) max = p[j][k] + p[k][i];
                }
                p[j][i] = max;
            }
        }
        return Math.max(p[0][prices.length - 1], 0);
    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1; i < prices.length; i++)
            if(prices[i] - prices[i - 1] > 0) sum += prices[i] - prices[i - 1];
        return sum;
    }


    public static void main(String[] args) {
        int[] test = {7,1,5,3,6,4};
        Solution122 solu = new Solution122();
        System.out.println(solu.maxProfit(test));
    }

}
