public class Solution633 {

    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int ans = left * left + right * right;
            if (ans == c) return true;
            else if (ans > c) right--;
            else if (ans < c) left++;
        }
        return false;
    }

}
