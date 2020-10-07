import java.util.Arrays;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return null;
        Arrays.sort(nums);
        int fast = nums.length - 1;
        for(int i = 0; i < fast; i++){
            while(nums[i] + nums[fast] > target) fast--;
            if(nums[i] + nums[fast] == target) return new int[]{i,fast};
        }
        return null;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(Arrays.toString(solu.twoSum(new int[]{3,2,4}, 6)));
    }

}
