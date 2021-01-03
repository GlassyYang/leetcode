import java.util.*;

public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        int ansI = 0, maxI = 0, max = nums[0];
        for(int i = 0; i < k; i++) {
            if (max <= nums[i]) {
                max = nums[i];
                maxI = i;
            }
        }
        ans[ansI++] = max;
        for (int i = 1; i <= nums.length - k; i++) {
            if (maxI >= i) {
                if (nums[i + k - 1] < max) {
                    ans[ansI++] = max;
                } else {
                    maxI = i + k - 1;
                    max = nums[i + k - 1];
                    ans[ansI++] = max;
                }
            } else {
                // 重新寻找虚拟的MAX值
                max = nums[i];
                maxI = i;
                for (int j = i + 1; j < i + k; j++) {
                    if (nums[j] >= max) {
                        max = nums[j];
                        maxI = j;
                    }
                }
                ans[ansI++] = max;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution239 solu = new Solution239();
        int[] test = {1,-1};
        System.out.println(Arrays.toString(solu.maxSlidingWindow(test, 1)));
    }
}
