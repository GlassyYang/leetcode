import java.util.*;

public class Solution18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 4; i++){
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for(int j = i + 1; j <= nums.length - 3; j++){
                if(j > 0 && nums[j] == nums[j - 1])
                    continue;
                int start = j + 1, end = nums.length - 1;
                while (start < end){
                    if(nums[i] + nums[j] + nums[start] + nums[end] < target){
                        start++;
                    }else if(nums[i] + nums[j] + nums[start] + nums[end] > target){
                        end--;
                    }else{
                        List<Integer> e = new ArrayList<>(4);
                        e.add(nums[i]);
                        e.add(nums[j]);
                        e.add(nums[start]);
                        e.add(nums[end]);
                        ans.add(e);
                        start++;
                    }
                    while(start < nums.length - 1 && nums[start - 1] == nums[start])
                        start++;
                    while(end > start && nums[end - 1] == nums[end])
                        end--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
    }

}
