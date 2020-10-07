public class Solution66 {

    public int[] plusOne(int[] digits) {
        if(digits == null) return null;
        if(digits.length == 0) return new int[]{1};
        boolean flag = digits[digits.length - 1] == 9;
        digits[digits.length - 1] = flag ? 0 : digits[digits.length - 1] + 1;
        if (!flag) return digits;
        for (int i = digits.length - 2; i >= 0; i--) {
            digits[i] = digits[i] == 9 ? 0 : digits[i] + 1;
            flag = digits[i] == 0;
            if (!flag) return digits;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = digits[i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
