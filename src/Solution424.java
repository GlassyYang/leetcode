import java.util.*;

public class Solution424 {

    // 滑动窗解决这个问题
    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0, temp;
        while (right < n) {
            temp = s.charAt(right) - 'A';
            num[temp]++;
            maxn = Math.max(maxn, num[temp]);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        Solution424 solu = new Solution424();
//        System.out.println(solu.characterReplacement("ABAB", 2));
        System.out.println(solu.characterReplacement("AABABBA", 1));
    }

}
