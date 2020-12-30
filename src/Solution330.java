import java.util.*;

public class Solution330 {

    public int minPatches(int[] nums, int n) {
        int ans = 0, length = nums.length, index = 0;
        long x = 1;
        while(x <= n) {
            if (index < length && nums[index] <= x) x += nums[index++];
            else {
                x *= 2;
                ans++;
            }
        }
        return ans;
    }

}
