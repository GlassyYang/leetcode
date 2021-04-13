import java.util.*;

public class OfferSolution56I {

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum ^= nums[i];
        }
        int mask = 0x1;
        while ((sum & mask) == 0) mask <<= 1;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            int e = nums[i];
            if ((e & mask) == 0) {
                left ^= e;
            } else {
                right ^= e;
            }
        }
        return new int[]{left, right};
    }

}
