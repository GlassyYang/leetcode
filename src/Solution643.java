import java.util.*;

public class Solution643 {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, average = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        average = sum / k;
        for (int i = 0; i <= nums.length - k; i++) {
            average = Math.max(average, sum / k);
            sum -= nums[i];
            if (i + k < nums.length) sum += nums[i + k];

        }
        return average;
    }

    public static void main(String[] args) {
        Solution643 solu = new Solution643();
//        int[] nums = {1,12,-5,-6,50,3};
        int[] nums = {-1};
        System.out.println(solu.findMaxAverage(nums, 1));
    }

}
