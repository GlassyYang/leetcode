public class Solution70 {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int temp = prev + cur;
            prev = cur;
            cur = temp;
        }
        return cur;
    }

}
