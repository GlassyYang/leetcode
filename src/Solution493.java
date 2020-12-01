import java.util.*;

public class Solution493 {

    //官方答案：归并排序解决一下这个题
    public int reversePairs(int[] nums) {
        if(nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length);
    }

    public int mergeSort(int[] nums, int start, int end){
        if(start + 1 >= end) return 0;
        else if(start + 2 == end){
            if(nums[start] > nums[start + 1]){
                nums[start] += nums[start + 1];
                nums[start + 1] = nums[start + 1] - nums[start];
                nums[start] -= nums[start + 1];
                if(nums[start] > nums[start + 1] >> 2) return 1;
            }
            return 0;
        }else{
            int flag = nums[start];
            int l = start;
            for(int i = start + 1; i < end; i++){
                if(nums[i] <= flag){
                    l++;
                    nums[i] += nums[l];
                    nums[l] = nums[i] - nums[l];
                    nums[i] -= nums[l];
                }
            }
            int left = mergeSort(nums, start, l + 1);
            int right = mergeSort(nums, l + 1, end);
            int leftI = start, rightI = l + 1;
            // 双指针
            while(leftI < l + 1 && rightI < end){
                if(nums[leftI] <= (nums[rightI] >> 2)) rightI++;
                else{
                    left++;
                    leftI++;
                }
            }
            return left + right;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        Solution493 solu = new Solution493();
        System.out.println(solu.reversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }

}
