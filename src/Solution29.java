import java.util.*;

public class Solution29 {
    // 利用二分搜索解决这道题

    public int divide(int dividend, int divisor) {
        long first = Math.abs((long) dividend), second = Math.abs((long) divisor);
        long ans = 0, ansBlock, secondBlock;
        while (first >= second) {
            secondBlock = second;
            ansBlock = 1;
            while (secondBlock <= first) {
                secondBlock <<= 1;
                ansBlock <<= 1;
            }
            secondBlock >>= 1;
            ansBlock >>= 1;
            ans += ansBlock;
            first -= secondBlock;
        }
        if (dividend > 0) {
            if (divisor > 0) {
                if (ans == 2147483648L) return Integer.MAX_VALUE;
                return (int) ans;
            }
            else return -(int) ans;
        }
        if (dividend < 0){
            if (divisor < 0) {
                if (ans == 2147483648L) return Integer.MAX_VALUE;
                return (int) ans;
            }
            else return -(int) ans;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution29 solu = new Solution29();
        System.out.println(solu.divide(-2147483648, -1));
    }

}
