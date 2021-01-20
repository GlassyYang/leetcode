import java.util.*;

public class Solution628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int right = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int left = nums[0] * nums[1] * nums[len - 1];
        return Math.max(right, left);
    }

}
