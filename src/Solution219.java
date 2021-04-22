import java.util.*;

public class Solution219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (i - k >= 0) set.remove(nums[i - k]);
        }
        return false;
    }

}
