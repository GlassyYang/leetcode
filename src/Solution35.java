public class Solution35 {

    public static int searchInsert(int[] nums, int target) {

        if(nums[0] > target) return 0;
        if(nums[0] == target) return 0;
        int start = 0, end = nums.length;
        int mid = (start + end) / 2;
        while(start < mid){
            if(nums[mid] < target)
                start = mid;
            else if(nums[mid] > target)
                end = mid;
            else
                return mid;
            mid = (start + end) / 2;
        }

        return (end < nums.length && nums[end] < target) ? end + 1 : end;
    }

    public static void main(String[] args) {

        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
    }
}
