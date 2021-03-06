import java.util.*;

import static java.lang.Math.*;

public class Solution1755 {
    // 初步想法：动态规划，貌似不行，只能暴力搜索
    public int minAbsDifferenceWrong(int[] nums, int goal) {
        int[] dp = new int[nums.length + 1];
        int[] sum = new int[nums.length + 1];
        dp[0] = Math.abs(goal - 0);
        sum[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int ni = i - 1;
            dp[i] = Math.min(dp[0], Math.abs(goal - sum[0] - nums[ni]));
            sum[i] = sum[0] + nums[ni];
            for (int j = 0; j < i; j++) {
                if (dp[j] < dp[i]) {
                    dp[i] = dp[j];
                    sum[i] = sum[j];
                }
                int temp = Math.abs(goal - sum[j] - nums[ni]);
                if (temp < dp[i]) {
                    dp[i] = temp;
                    sum[i] = sum[j] + nums[ni];
                }
            }
        }
        return dp[nums.length];
    }

    static int lower_bound(int[] g, int target) {
        /**
         * g中搜索≥target的第一个数字的位置[l,r)
         * */
        int l = 0, r = g.length;
        //if(target>g[r-1])return r;
        while (l + 1 < r) {
            int mid = l + (r - 1 - l) / 2;
            if (g[mid] < target) {
                l = mid + 1;
            } else if (g[mid] >= target) {
                r = mid + 1;
            }
        }
        return l;
    }

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int n1 = (n + 1) / 2, n2 = n - n1;
        int[] f1 = new int[(1 << n1)], f2 = new int[(1 << n2)];
        for (int i = 0; i < (1 << n1); ++i) {       //前半部分所有组合
            for (int j = 0; j < n1; ++j) {
                if (((i >> j) & 1) == 1) {
                    f1[i] += nums[j];
                }
            }
        }
        for (int i = 0; i < (1 << n2); ++i) {       //后半部分所有组合
            for (int j = 0; j < n2; ++j) {
                if (((i >> j) & 1) == 1) {
                    f2[i] += nums[n1 + j];
                }
            }
        }
        Arrays.sort(f2);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < f1.length; ++i) {       //枚举f1
            int target = goal - f1[i];
            int index = lower_bound(f2, target);    //二分查找f2
            if (index < f2.length) {
                ans = min(ans, abs(f1[i] + f2[index] - goal));
            }
            if (index - 1 >= 0) {
                ans = min(ans, abs(f1[i] + f2[index - 1] - goal));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1755 solu = new Solution1755();
        int[] test = {5, -7, 3, 5};
//        int[] test = {7, -9, 15, -2};
        System.out.println(solu.minAbsDifference(test, 6));
    }

}
