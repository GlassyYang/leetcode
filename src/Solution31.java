import java.util.*;

public class Solution31 {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int mini = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]){
                mini = i;
                for(int j = i + 1; j < nums.length; j++) if(nums[j] > nums[i - 1] && nums[j] < nums[mini]) mini = j;
                nums[mini] = nums[mini] - nums[i - 1];
                nums[i - 1] = nums[i - 1] + nums[mini];
                nums[mini] = nums[i - 1] - nums[mini];
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int i = 1, j = 2;
        i = i - j;
        j = i + j;
        i = j - i;
//        System.out.println(i);
//        System.out.println(j);
        Solution31 solu = new Solution31();
        int[] test = {2,3,1};
        solu.nextPermutation(test);
        System.out.println(Arrays.toString(test));
    }

}
