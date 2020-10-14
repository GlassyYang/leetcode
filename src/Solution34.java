import java.util.Arrays;

public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int start = 0, end = nums.length -1;
        int mid = (start + end) / 2;
        while(start < mid){
            if(nums[mid] < target)start = mid;
            else if(nums[mid] > target) end = mid;
            else break;
            if(mid == (start +  end) / 2) break;
            mid = (start +  end) / 2;
        }
        if(nums[mid] == target){
            int end1 = mid, start2 = mid + 1;
            int mid1 = (start + end1) / 2, mid2 = (start2 + end) / 2;
            int tstart, tend;
            while(start < mid1){
                if(nums[mid1] >= target) end1 = mid1;
                else start = mid1;
                if(mid1 == (start + end1) / 2) break;
                mid1 = (start + end1) / 2;
            }
            tstart = mid1;
            for(int i = end1; i >= start; i--) if(nums[i] == target) tstart = i;
            while(start2 < mid2){
                if(nums[mid2] <= target) start = mid2;
                else end = mid2;
                if(mid2 == (start2 + end) / 2) break;
                mid2 = (start2 + end) / 2;
            }
            tend = mid2;
            for(int i = start2; i <= end; i++) if(nums[i] == target) tend = i;
            return new int[]{nums[tstart] == target ? tstart : mid, nums[tend] == target ?  tend : mid};
        }else return nums[nums.length - 1] == target ?  new int[]{nums.length - 1, nums.length - 1} : new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,3,4,5,9};
        Solution34 solu = new Solution34();
        System.out.println(Arrays.toString(solu.searchRange(nums, 3)));
    }

}
