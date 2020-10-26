import java.util.*;

public class Solution1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums == null) return null;
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) ans[i] = nums[i];
        Arrays.sort(nums);
        int temp;
        for(int i = 0; i < ans.length; i++){
            temp = Arrays.binarySearch(nums, ans[i]);
            if(temp == 0) ans[i] = temp;
            else{
                while(temp >= 0 && nums[temp] == ans[i]) temp--;
                ans[i] = temp + 1;
            }
        }
        return ans;
    }

}
