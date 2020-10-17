public class Solution121 {

    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[] p = new int[prices.length];
        p[0] = 0;
        for(int i = 1; i < p.length; i++){
            p[i] = Math.max(p[i - 1] + prices[i] - prices[i - 1], prices[i] - prices[i - 1]);
        }
        int max = p[0];
        for(int i = 1; i < p.length; i++) if(max < p[i]) max = p[i];
        return Math.max(max, 0);
    }

    public static void main(String[] args) {
        int[] test = new int[]{7,1,5,3,6,4};
        Solution121 solu = new Solution121();
        System.out.println(solu.maxProfit(test));
    }

}
