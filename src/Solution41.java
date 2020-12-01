import java.util.*;

public class Solution41 {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int prev = -1;
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1){
                int temp = nums[i] - 1;
                if(prev == temp) break;
                nums[i] = nums[temp];
                nums[temp] = temp + 1;
                prev = temp;
            }
        }
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != i + 1) return i + 1;
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] test = {3,4,-1,1};
        Solution41 solu = new Solution41();
        System.out.println(solu.firstMissingPositive(new int[]{1, 1}));
    }
}
