import java.util.*;

public class Solution518 {

    // 完全背包问题的一种变形
    public int change(int amount, int[] coins) {
        int[] buf = new int[amount + 1];
        buf[0] = 1;
        for (int i = 0; i < coins.length; i++) {
                for(int j = 1; j <= amount; j++)
                    if(j >= coins[i])
                        buf[j] += buf[j - coins[i]];
        }
        return buf[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        Solution518 solu = new Solution518();
        System.out.println(solu.change(5, coins));

    }

}
