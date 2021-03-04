import java.util.*;

public class Solution300 {

    // 用贪心加二分搜索的方法求最长上升子序列
    public int lengthOfLIS(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int temp = ls.get(ls.size() - 1);
            if (nums[i] > temp) {
                ls.add(nums[i]);
            } else {
                int index = Collections.binarySearch(ls, nums[i]);
                ls.set(-1 - index, nums[i]);
            }
        }
        return ls.size();
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        Solution300 solu = new Solution300();
        System.out.println(solu.lengthOfLIS(nums));
    }

}
