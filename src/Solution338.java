import java.util.*;
public class Solution338 {

    // 动态规划，找规律
    public int[] countBitsAns(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int[] ans = new int[num + 1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

}
