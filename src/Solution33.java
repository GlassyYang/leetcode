import java.util.*;

public class Solution33 {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1){
            if(nums[0] != target)return -1;
            return 0;
        }
        int begin = 0, end = nums.length - 1, mid = -1;
        while(begin + 1 != end){
            mid = (begin + end) / 2;
            if(nums[mid] == target) return mid;
            if(nums[begin] >= nums[mid]){
                if(nums[mid] <= target && nums[end] >= target) begin = mid;
                else end = mid;
            }else{
                if(nums[begin] <= target && nums[mid] >= target) end = mid;
                else begin = mid;
            }
        }
        if(nums[begin] == target) return begin;
        if(nums[end] == target) return end;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        Solution33 solu = new Solution33();
        System.out.println(solu.search(nums, 3));
    }

}
