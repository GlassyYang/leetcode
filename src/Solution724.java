import java.util.*;

public class Solution724 {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int sum = 0, left = 0;
        for (int i : nums) {
            sum += i;
        }
        sum -= nums[0];
        for (int i = 1; i < nums.length; i++) {
            left += nums[i - 1];
            sum -= nums[i];
            if (left == sum) {
                return i;
            }
        }
        return -1;
    }

}
