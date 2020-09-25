import java.util.*;

public class Solution26 {

    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int count= 0, index = -1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1])
                count++;
            else{
                index++;
                nums[index] = nums[i];
            }
        }
        index++;
        nums[index] = nums[nums.length - 1];
        return nums.length - count;
    }

    public static void main(String[] args) {
//        int[] test = {1,1,2,2};
        Set<Integer> ans = new HashSet<>();
        ans.add(1);
        ans.add(2);
        Set<Integer> ans2 = new HashSet<>();
        ans2.add(2);
//        ans2.add(1);
        System.out.println(ans2.equals(ans));
//        System.out.println(removeDuplicates(test));
//        System.out.println(Arrays.toString(test));
    }


}
