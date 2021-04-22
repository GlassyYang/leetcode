public class Solution198 {
    // 简单动态规划
    public int rob(int[] nums) {
        int notRob = 0, rob = 0;
        for (int num : nums) {
            int temp = notRob;
            notRob = Math.max(notRob, rob);
            rob = temp + num;
        }
        return Math.max(notRob, rob);
    }


}
