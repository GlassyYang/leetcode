import java.util.*;

public class Solution153 {

    // 二分搜索寻找旋转排序数组的最小值
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, mid = (start + end) / 2;
        while(start < mid) {
            if(nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (start + end) / 2;
        }
        return Math.min(nums[start], nums[end]);
    }

}
