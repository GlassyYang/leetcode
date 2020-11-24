import java.util.*;

public class Solution283 {

    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        for(int i = 0; i < nums.length; i++) if(nums[i] != 0) nums[nonZero++] = nums[i];
        while(nonZero < nums.length){
            nums[nonZero++] = 0;
        }
    }


    public static void main(String[] args) {
        int[] test = {1,1,2,3,12};
        Solution283 solu = new Solution283();
        solu.moveZeroes(test);
        System.out.println(Arrays.toString(test));
    }

}
